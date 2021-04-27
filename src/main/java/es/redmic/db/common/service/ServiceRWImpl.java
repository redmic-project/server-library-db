package es.redmic.db.common.service;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.config.OrikaScanBeanDBItfc;
import es.redmic.exception.database.DBConstraintViolationException;
import es.redmic.exception.database.DBNotFoundException;
import es.redmic.exception.database.DBPropertyValueException;
import es.redmic.models.es.common.dto.DTO;
import es.redmic.models.es.common.dto.DTOEvent;

public abstract class ServiceRWImpl<TModel extends LongModel, TDTO extends DTO>
		implements IServiceRW<TModel, TDTO>, ApplicationEventPublisherAware {

	@Autowired
	protected OrikaScanBeanDBItfc factory;

	protected ApplicationEventPublisher eventPublisher;

	protected Class<TDTO> typeOfTDTO;
	protected Class<TDTO> typeOfTModel;

	protected BaseRepository<TModel, Long> repository;

	protected static String DELETE_EVENT = "DELETE";
	protected static String ADD_EVENT = "ADD";
	protected static String UPDATE_EVENT = "UPDATE";

	protected static final Logger LOGGER = LoggerFactory.getLogger(ServiceRWImpl.class);

	@SuppressWarnings("unchecked")
	@Autowired
	public ServiceRWImpl(BaseRepository<TModel, Long> repository) {
		this.repository = repository;
		this.typeOfTModel = (Class<TDTO>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.typeOfTDTO = (Class<TDTO>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Override
	public TDTO save(TDTO dto) {
		TModel model = convertDtoToModel(dto);
		TDTO result = convertModelToDto(this.saveModel(model));
		publish(ADD_EVENT, result);
		return result;
	}

	@Override
	public TModel saveModel(TModel model) {
		return persist(model);
	}

	@Override
	public TDTO update(TDTO dto) {
		findById(dto.getId());
		TModel model = convertDtoToModel(dto);
		TDTO result = convertModelToDto(updateModel(model));
		publish(UPDATE_EVENT, result);
		return result;
	}

	@Override
	public TModel updateModel(TModel model) {
		return persist(model);
	}

	@Override
	@Transactional
	public TModel persist(TModel model) {
		try {
			model = repository.saveAndFlush(model);
			return findById(model.getId());
		} catch (DataIntegrityViolationException e) {
			throw new DBConstraintViolationException(e);
		} catch (ConstraintViolationException e) {
			throw new DBPropertyValueException(e);
		}
	}

	@Override
	public void delete(Long id) {

		delete(findById(id));
	}

	public void delete(TModel model) {

		TDTO result = convertModelToDto(model);
		deleteModel(model);
		publish(DELETE_EVENT, result);
	}

	public void publish(String eventType, TDTO result) {

		this.eventPublisher.publishEvent(new DTOEvent(this, eventType, result));
	}

	@Override
	public void deleteModel(TModel model) {
		repository.delete(model);
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = { DBNotFoundException.class })
	public TModel findById(Long id) {
		Optional<TModel> model = repository.findById(id);

		if (model == null || !model.isPresent()) {
			throw new DBNotFoundException("id", String.valueOf(id));
		}

		return model.get();
	}

	@Transactional(readOnly = true)
	public TModel findOne(Long id) {
		return repository.findById(id).get();
	}

	@SuppressWarnings("unchecked")
	public TModel convertDtoToModel(TDTO dto) {
		TModel model = (TModel) factory.getMapperFacade().map(dto, typeOfTModel);
		return model;
	}

	@Override
	public TDTO convertModelToDto(TModel model) {
		TDTO dto = factory.getMapperFacade().map(model, typeOfTDTO);
		return dto;
	}
}

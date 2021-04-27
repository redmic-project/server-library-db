package es.redmic.db.series.common.service;

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

import org.springframework.beans.factory.annotation.Autowired;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.db.geodata.properties.fixedsurvey.repository.FixedMeasurementRepository;
import es.redmic.exception.database.DBNotFoundException;
import es.redmic.models.es.series.common.dto.SeriesBaseDTO;

//TODO: al refactorizar series pasar esto a service específico de timeseries 
public abstract class RWBaseSeriesService<TModel extends LongModel, TDTO extends SeriesBaseDTO>
		extends ServiceRWImpl<TModel, TDTO> {

	@Autowired
	private FixedMeasurementRepository stationMeasurementRepository;

	public RWBaseSeriesService(BaseRepository<TModel, Long> repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public TDTO save(TDTO dto) {

		if (dto.getDataDefinition() == null)
			throw new DBNotFoundException("dataDefinitionId", "null");

		TModel model = convertDtoToModel(dto);

		FixedMeasurement stationMeasurement = stationMeasurementRepository
				.findByDataDefinitionId(dto.getDataDefinition());

		if (stationMeasurement == null)
			throw new DBNotFoundException("stationMeasurement.dataDefinitionId",
					String.valueOf(dto.getDataDefinition()));

		model = setFixedMeasurement(model, stationMeasurement);
		model = setReferences(model, dto);
		TDTO result = convertModelToDto(saveModel(model));
		result.set_grandparentId(stationMeasurement.getFixedSurvey().getActivity().getId().toString());
		result.set_parentId(stationMeasurement.getFixedSurvey().getUuid());
		publish(ADD_EVENT, result);
		return result;
	}

	public TDTO update(TDTO dto) {

		if (dto.getDataDefinition() == null)
			throw new DBNotFoundException("dataDefinitionId", "null");

		TModel item = findById(dto.getId());

		if (item == null)
			throw new DBNotFoundException("id", String.valueOf(dto.getId()));

		TModel model = convertDtoToModel(dto);

		FixedMeasurement stationMeasurement = stationMeasurementRepository
				.findByDataDefinitionId(dto.getDataDefinition());

		if (stationMeasurement == null)
			throw new DBNotFoundException("stationMeasurement.dataDefinitionId",
					String.valueOf(dto.getDataDefinition()));

		model = setFixedMeasurement(model, stationMeasurement);
		model = setReferences(model, dto);
		TDTO result = convertModelToDto(updateModel(model));
		result.set_grandparentId(stationMeasurement.getFixedSurvey().getActivity().getId().toString());
		result.set_parentId(stationMeasurement.getFixedSurvey().getUuid());
		publish(UPDATE_EVENT, result);
		return result;
	}

	protected abstract TModel setFixedMeasurement(TModel model, FixedMeasurement stationMeasurement);

	protected abstract TModel setReferences(TModel model, TDTO dto);
}

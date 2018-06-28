package es.redmic.db.series.common.service;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.exception.database.DBNotFoundException;
import es.redmic.models.es.series.common.dto.SeriesCommonDTO;

public abstract class SeriesService<TModel extends LongModel, TDTO extends SeriesCommonDTO>
		extends ServiceRWImpl<TModel, TDTO> {

	public SeriesService(BaseRepository<TModel, Long> repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public TDTO save(TDTO dto) {

		TModel model = convertDtoToModel(dto);
		model = setReferences(model, dto);
		TDTO result = convertModelToDto(saveModel(model));
		result.set_grandparentId(dto.get_grandparentId());
		result.set_parentId(dto.get_parentId());
		publish(ADD_EVENT, result);
		return result;
	}

	public TDTO update(TDTO dto) {

		TModel item = findById(dto.getId());

		if (item == null)
			throw new DBNotFoundException("id", String.valueOf(dto.getId()));

		TModel model = convertDtoToModel(dto);
		model = setReferences(model, dto);
		TDTO result = convertModelToDto(updateModel(model));
		result.set_grandparentId(dto.get_grandparentId());
		result.set_parentId(dto.get_parentId());
		publish(UPDATE_EVENT, result);
		return result;
	}

	protected abstract TModel setReferences(TModel model, TDTO dto);
}

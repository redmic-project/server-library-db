package es.redmic.db.administrative.service;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.model.ActivityBase;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.models.es.administrative.dto.ActivityBaseDTO;

public class ActivityBaseService<TModel extends ActivityBase, TDTO extends ActivityBaseDTO> extends
		ServiceRWImpl<TModel, TDTO> {

	public ActivityBaseService(BaseRepository<TModel, Long> repository) {
		super(repository);
	}
}

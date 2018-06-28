package es.redmic.db.common.service;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.common.model.DomainModel;
import es.redmic.models.es.common.dto.DomainDTO;

public abstract class ServiceDomain<TModel extends DomainModel, TDTO extends DomainDTO> extends
		ServiceRWImpl<TModel, TDTO> {

	public ServiceDomain(BaseRepository<TModel, Long> repository) {
		super(repository);
	}
}

package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.Origin;
import es.redmic.db.maintenance.taxonomy.repository.OriginRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.OriginDTO;

@Service
public class OriginService extends ServiceDomain<Origin, OriginDTO> {

	@Autowired
	public OriginService(OriginRepository repository) {
		super(repository);
	}
}

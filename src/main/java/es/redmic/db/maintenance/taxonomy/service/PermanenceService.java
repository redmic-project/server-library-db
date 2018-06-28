package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.Permanence;
import es.redmic.db.maintenance.taxonomy.repository.PermanenceRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.PermanenceDTO;

@Service
public class PermanenceService extends
		ServiceDomain<Permanence, PermanenceDTO> {

	@Autowired
	public PermanenceService(PermanenceRepository repository) {
		super(repository);
	}
}

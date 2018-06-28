package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.Endemicity;
import es.redmic.db.maintenance.taxonomy.repository.EndemicityRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.EndemicityDTO;

@Service
public class EndemicityService extends
		ServiceDomain<Endemicity, EndemicityDTO> {

	@Autowired
	public EndemicityService(EndemicityRepository repository) {
		super(repository);
	}
}

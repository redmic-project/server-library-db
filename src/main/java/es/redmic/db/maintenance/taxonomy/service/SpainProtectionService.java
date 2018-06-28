package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.SpainProtection;
import es.redmic.db.maintenance.taxonomy.repository.SpainProtectionRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.SpainProtectionDTO;

@Service
public class SpainProtectionService extends
		ServiceDomain<SpainProtection, SpainProtectionDTO> {

	@Autowired
	public SpainProtectionService(SpainProtectionRepository repository) {
		super(repository);
	}
}

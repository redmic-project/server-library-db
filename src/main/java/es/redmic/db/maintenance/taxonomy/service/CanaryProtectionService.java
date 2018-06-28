package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.CanaryProtection;
import es.redmic.db.maintenance.taxonomy.repository.CanaryProtectionRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.CanaryProtectionDTO;

@Service
public class CanaryProtectionService extends ServiceDomain<CanaryProtection, CanaryProtectionDTO> {

	@Autowired
	public CanaryProtectionService(CanaryProtectionRepository repository) {
		super(repository);
	}
}

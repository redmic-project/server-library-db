package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.EUProtection;
import es.redmic.db.maintenance.taxonomy.repository.EUProtectionRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.EUProtectionDTO;

@Service
public class EUProtectionService extends
		ServiceDomain<EUProtection, EUProtectionDTO> {

    @Autowired
	public EUProtectionService(EUProtectionRepository repository) {
        super(repository);
    }
}

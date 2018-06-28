package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.Ecology;
import es.redmic.db.maintenance.taxonomy.repository.EcologyRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.EcologyDTO;

@Service
public class EcologyService extends ServiceDomain<Ecology, EcologyDTO> {

	@Autowired
	public EcologyService(EcologyRepository repository) {
		super(repository);
	}
}

package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.Interest;
import es.redmic.db.maintenance.taxonomy.repository.InterestRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.InterestDTO;

@Service
public class InterestService extends
		ServiceDomain<Interest, InterestDTO> {

	@Autowired
	public InterestService(InterestRepository repository) {
		super(repository);
	}
}

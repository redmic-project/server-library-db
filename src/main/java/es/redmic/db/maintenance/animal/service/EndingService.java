package es.redmic.db.maintenance.animal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.animal.model.Ending;
import es.redmic.db.maintenance.animal.repository.EndingRepository;
import es.redmic.models.es.maintenance.animal.dto.EndingDTO;

@Service
public class EndingService extends
		ServiceDomain<Ending, EndingDTO> {

	@Autowired
	public EndingService(EndingRepository repository) {
		super(repository);
	}
}

package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.Status;
import es.redmic.db.maintenance.taxonomy.repository.StatusRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.StatusDTO;

@Service
public class StatusService extends
		ServiceDomain<Status, StatusDTO> {

	@Autowired
	public StatusService(StatusRepository repository) {
		super(repository);
	}
}

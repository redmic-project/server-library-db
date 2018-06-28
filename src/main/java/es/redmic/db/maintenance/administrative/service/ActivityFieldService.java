package es.redmic.db.maintenance.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.administrative.model.ActivityField;
import es.redmic.db.maintenance.administrative.repository.ActivityFieldRepository;
import es.redmic.models.es.maintenance.administrative.dto.ActivityFieldDTO;

@Service
public class ActivityFieldService extends
		ServiceDomain<ActivityField, ActivityFieldDTO> {

	@Autowired
	public ActivityFieldService(ActivityFieldRepository repository) {
		super(repository);
	}
}

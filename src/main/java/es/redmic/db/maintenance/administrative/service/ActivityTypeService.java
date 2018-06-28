package es.redmic.db.maintenance.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.maintenance.administrative.model.ActivityType;
import es.redmic.db.maintenance.administrative.repository.ActivityTypeRepository;
import es.redmic.models.es.maintenance.administrative.dto.ActivityTypeDTO;

@Service
public class ActivityTypeService extends ServiceRWImpl<ActivityType, ActivityTypeDTO> {

	@Autowired
	public ActivityTypeService(ActivityTypeRepository repository) {
		super(repository);
	}
}

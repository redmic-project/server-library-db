package es.redmic.db.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.model.ActivityResource;
import es.redmic.db.administrative.repository.ActivityResourceRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.models.es.administrative.dto.ActivityResourceDTO;

@Service
public class ActivityResourceService extends ServiceRWImpl<ActivityResource, ActivityResourceDTO> {

	@Autowired
	public ActivityResourceService(ActivityResourceRepository repository) {
		super(repository);
	}
}

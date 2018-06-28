package es.redmic.db.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.administrative.repository.ActivityRepository;
import es.redmic.models.es.administrative.dto.ActivityDTO;

@Service
public class ActivityService extends ActivityBaseService<Activity, ActivityDTO> {

	@Autowired
	public ActivityService(ActivityRepository repository) {
		super(repository);
	}
	
	/**
	 * Sobrescribe el método para poder setear el activityCategory guardado ya que es un 
	 * dato que no viene en el dto 
	 **/
	@Override
	public ActivityDTO update(ActivityDTO dto) {
		Activity original = findById(dto.getId());
		Activity model = convertDtoToModel(dto);
		model.setActivityCategory(original.getActivityCategory());
		ActivityDTO result = convertModelToDto(updateModel(model));
		publish(UPDATE_EVENT, result);
		return result;
	}
}

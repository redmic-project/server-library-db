package es.redmic.db.administrative.service;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

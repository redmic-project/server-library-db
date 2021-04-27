package es.redmic.db.geodata.tracking.animal.mapper;

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

import org.springframework.stereotype.Component;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.geodata.tracking.animal.model.AnimalTracking;
import es.redmic.models.es.geojson.tracking.animal.dto.AnimalTrackingDTO;
import es.redmic.models.es.geojson.tracking.animal.dto.AnimalTrackingPropertiesDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class AnimalTrackingMapper extends CustomMapper<AnimalTracking, AnimalTrackingDTO> {

	@Override
	public void mapAtoB(AnimalTracking a, AnimalTrackingDTO b, MappingContext context) {
		AnimalTrackingPropertiesDTO properties = mapperFacade.map(a, AnimalTrackingPropertiesDTO.class);
		b.setGeometry(a.getGeometry());
		b.setProperties(properties);
		b.getProperties().setActivityId(a.getActivity().getId().toString());
		b.setId(a.getId());
		b.setUuid(a.getUuid());
	}

	@Override
	public void mapBtoA(AnimalTrackingDTO b, AnimalTracking a, MappingContext context) {
		mapperFacade.map(b.getProperties(), a);
		a.setGeometry(b.getGeometry());
		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}
}

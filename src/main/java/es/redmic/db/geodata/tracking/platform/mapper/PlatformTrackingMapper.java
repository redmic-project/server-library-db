package es.redmic.db.geodata.tracking.platform.mapper;

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
import es.redmic.db.geodata.tracking.platform.model.PlatformTracking;
import es.redmic.models.es.geojson.tracking.platform.dto.PlatformTrackingDTO;
import es.redmic.models.es.geojson.tracking.platform.dto.PlatformTrackingPropertiesDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class PlatformTrackingMapper extends CustomMapper<PlatformTracking, PlatformTrackingDTO> {

	@Override
	public void mapAtoB(PlatformTracking a, PlatformTrackingDTO b, MappingContext context) {

		b.setGeometry(a.getGeometry());

		b.setId(a.getId());
		b.setUuid(a.getUuid());

		PlatformTrackingPropertiesDTO properties = mapperFacade.map(a, PlatformTrackingPropertiesDTO.class);
		b.setProperties(properties);
		b.getProperties().setActivityId(a.getActivity().getId().toString());
	}

	@Override
	public void mapBtoA(PlatformTrackingDTO b, PlatformTracking a, MappingContext context) {

		mapperFacade.map(b.getProperties(), a);
		a.setGeometry(b.getGeometry());
		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}

}

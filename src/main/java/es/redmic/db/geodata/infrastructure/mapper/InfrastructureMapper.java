package es.redmic.db.geodata.infrastructure.mapper;

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
import es.redmic.db.geodata.infrastructure.model.Infrastructure;
import es.redmic.db.maintenance.point.model.InfrastructureType;
import es.redmic.models.es.geojson.infrastructure.dto.InfrastructureDTO;
import es.redmic.models.es.geojson.infrastructure.dto.InfrastructurePropertiesDTO;
import es.redmic.models.es.maintenance.point.dto.InfrastructureTypeBaseDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class InfrastructureMapper extends CustomMapper<Infrastructure, InfrastructureDTO> {

	@Override
	public void mapAtoB(Infrastructure a, InfrastructureDTO b, MappingContext context) {

		InfrastructurePropertiesDTO properties = mapperFacade.map(a, InfrastructurePropertiesDTO.class);
		b.setGeometry(a.getGeometry());
		b.setProperties(properties);

		if (a.getInfrastructureType() != null)
			b.getProperties().setInfrastructureType(
					mapperFacade.map(a.getInfrastructureType(), InfrastructureTypeBaseDTO.class));

		b.getProperties().setActivityId(a.getActivity().getId().toString());
		b.setId(a.getId());
		b.setUuid(a.getUuid());
	}

	@Override
	public void mapBtoA(InfrastructureDTO b, Infrastructure a, MappingContext context) {

		mapperFacade.map(b.getProperties(), a);
		a.setGeometry(b.getGeometry());

		if (b.getProperties() != null && b.getProperties().getInfrastructureType() != null)
			a.setInfrastructureType(
					mapperFacade.map(b.getProperties().getInfrastructureType(), InfrastructureType.class));

		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}
}

package es.redmic.db.geodata.area.mapper;

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
import es.redmic.db.geodata.area.model.Area;
import es.redmic.db.maintenance.areas.model.AreaClassification;
import es.redmic.db.maintenance.areas.model.AreaType;
import es.redmic.models.es.geojson.area.dto.AreaDTO;
import es.redmic.models.es.geojson.area.dto.AreaPropertiesDTO;
import es.redmic.models.es.geojson.common.dto.GeoDataRelationDTO;
import es.redmic.models.es.maintenance.areas.dto.AreaClassificationDTO;
import es.redmic.models.es.maintenance.areas.dto.AreaTypeDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class AreaMapper extends CustomMapper<Area, AreaDTO> {

	@Override
	public void mapAtoB(Area a, AreaDTO b, MappingContext context) {

		AreaPropertiesDTO properties = mapperFacade.map(a, AreaPropertiesDTO.class);
		b.setGeometry(a.getGeometry());
		b.setProperties(properties);

		if (a.getAreaType() != null) {
			b.getProperties().setAreaType(mapperFacade.map(a.getAreaType(), AreaTypeDTO.class));
		}

		if (a.getParent() != null) {
			b.getProperties().setParent(mapperFacade.map(a.getParent(), GeoDataRelationDTO.class));
		}

		if (a.getAreaClassification() != null && a.getAreaClassification().size() > 0) {
			b.getProperties().setAreaClassification(
					mapperFacade.mapAsList(a.getAreaClassification(), AreaClassificationDTO.class));
		}
		b.getProperties().setActivityId(a.getActivity().getId().toString());
		b.setId(a.getId());
		b.setUuid(a.getUuid());
	}

	@Override
	public void mapBtoA(AreaDTO b, Area a, MappingContext context) {

		mapperFacade.map(b.getProperties(), a);
		a.setGeometry(b.getGeometry());

		if (b.getProperties() != null && b.getProperties().getAreaType() != null) {
			a.setAreaType(mapperFacade.map(b.getProperties().getAreaType(), AreaType.class));
		}

		if (b.getProperties() != null && b.getProperties().getParent() != null) {
			a.setParent(mapperFacade.map(b.getProperties().getParent(), Area.class));
		}

		if (b.getProperties().getAreaClassification() != null && b.getProperties().getAreaClassification().size() > 0) {
			a.setAreaClassification(
					mapperFacade.mapAsList(b.getProperties().getAreaClassification(), AreaClassification.class));
		}
		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}
}

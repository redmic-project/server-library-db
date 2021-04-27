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

import es.redmic.db.maintenance.areas.model.AreaClassification;
import es.redmic.db.maintenance.areas.model.ThematicType;
import es.redmic.models.es.maintenance.areas.dto.AreaClassificationDTO;
import es.redmic.models.es.maintenance.areas.dto.ThematicTypeBaseDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class AreaClassificationMapper extends CustomMapper<AreaClassification, AreaClassificationDTO> {

	@Override
	public void mapAtoB(AreaClassification a, AreaClassificationDTO b, MappingContext context) {

		b.setType(mapperFacade.map(a.getThematicType(), ThematicTypeBaseDTO.class));
	}

	@Override
	public void mapBtoA(AreaClassificationDTO b, AreaClassification a, MappingContext context) {

		a.setThematicType(mapperFacade.map(b.getType(), ThematicType.class));
	}
}

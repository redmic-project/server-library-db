package es.redmic.db.geodata.properties.fixedsurvey.mapper;

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

import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;
import es.redmic.models.es.series.common.dto.HierarchicalParameterDTO;
import es.redmic.models.es.series.common.dto.MeasurementDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class FixedMeasurementMapper extends CustomMapper<FixedMeasurement, MeasurementDTO> {
	
	@Override
	public void mapAtoB(FixedMeasurement a, MeasurementDTO b, MappingContext context) {
		HierarchicalParameterDTO parDto = 
				mapperFacade.map(a.getDataDefinition().getParameterUnit().getParameter(), HierarchicalParameterDTO.class);
		UnitDTO unitDto = 
				mapperFacade.map(a.getDataDefinition().getParameterUnit().getUnit(), UnitDTO.class);
		
		b.setParameter(parDto);
		b.setUnit(unitDto);
		b.getDataDefinition().setZ(a.getZ());
	}
}

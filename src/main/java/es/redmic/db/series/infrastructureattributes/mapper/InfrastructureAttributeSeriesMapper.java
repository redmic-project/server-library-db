package es.redmic.db.series.infrastructureattributes.mapper;

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

import es.redmic.db.series.common.mapper.SeriesBaseMapper;
import es.redmic.db.series.infrastructureattributes.model.InfrastructureAttributes;
import es.redmic.models.es.series.attributeseries.dto.AttributeSeriesDTO;
import ma.glasnost.orika.MappingContext;

@Component
public class InfrastructureAttributeSeriesMapper
		extends SeriesBaseMapper<InfrastructureAttributes, AttributeSeriesDTO> {

	@Override
	public void mapAtoB(InfrastructureAttributes a, AttributeSeriesDTO b, MappingContext context) {

		super.mapAtoB(a, b, context);
		b.set_grandparentId(a.getInfrastructure().getActivity().getId().toString());
		b.set_parentId(a.getInfrastructure().getUuid());
	}

	@Override
	public void mapBtoA(AttributeSeriesDTO b, InfrastructureAttributes a, MappingContext context) {
		super.mapBtoA(b, a, context);
	}
}

package es.redmic.db.geodata.citation.mapping;

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
import es.redmic.db.geodata.citation.model.Citation;
import es.redmic.models.es.geojson.citation.dto.CitationDTO;
import es.redmic.models.es.geojson.citation.dto.CitationPropertiesDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class CitationMapper extends CustomMapper<Citation, CitationDTO> {

	@Override
	public void mapAtoB(Citation a, CitationDTO b, MappingContext context) {
		CitationPropertiesDTO properties = mapperFacade.map(a, CitationPropertiesDTO.class);
		b.setGeometry(a.getGeometry());
		b.setProperties(properties);
		b.getProperties().setActivityId(a.getActivity().getId().toString());
		b.setId(a.getId());
		b.setUuid(a.getUuid());
	}

	@Override
	public void mapBtoA(CitationDTO b, Citation a, MappingContext context) {
		mapperFacade.map(b.getProperties(), a);

		if (a.getEndDate() == null && a.getStartDate() != null)
			a.setEndDate(a.getStartDate());

		a.setGeometry(b.getGeometry());
		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}
}

package es.redmic.db.administrative.mapping;

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

import es.redmic.db.administrative.model.Contact;
import es.redmic.db.administrative.model.Organisation;
import es.redmic.models.es.administrative.dto.ContactDTO;
import es.redmic.models.es.administrative.dto.OrganisationDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class ContactMapper extends CustomMapper<Contact, ContactDTO> {

	@Override
	public void mapAtoB(Contact a, ContactDTO b, MappingContext context) {
		b.setAffiliation(mapperFacade.map(a.getOrganisation(), OrganisationDTO.class));
	}

	@Override
	public void mapBtoA(ContactDTO a, Contact b, MappingContext context) {
		b.setOrganisation(mapperFacade.map(a.getAffiliation(), Organisation.class));
	}
}

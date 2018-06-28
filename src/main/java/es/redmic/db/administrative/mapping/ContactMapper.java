package es.redmic.db.administrative.mapping;

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

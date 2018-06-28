package es.redmic.db.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.model.Contact;
import es.redmic.db.administrative.repository.ContactRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.models.es.administrative.dto.ContactDTO;

@Service
public class ContactService extends ServiceRWImpl<Contact, ContactDTO> {

	@Autowired
	public ContactService(ContactRepository repository) {
		super(repository);
	}
}

package es.redmic.db.maintenance.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.administrative.model.ContactRole;
import es.redmic.db.maintenance.administrative.repository.ContactRoleRepository;
import es.redmic.models.es.maintenance.administrative.dto.ContactRoleDTO;

@Service
public class ContactRoleService extends
		ServiceDomain<ContactRole, ContactRoleDTO> {

	@Autowired
	public ContactRoleService(ContactRoleRepository repository) {
		super(repository);
	}
}

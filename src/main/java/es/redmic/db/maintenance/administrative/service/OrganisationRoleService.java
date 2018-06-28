package es.redmic.db.maintenance.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.repository.OrganisationRoleRepository;
import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.administrative.model.OrganisationRole;
import es.redmic.models.es.maintenance.administrative.dto.OrganisationRoleDTO;

@Service
public class OrganisationRoleService extends
		ServiceDomain<OrganisationRole, OrganisationRoleDTO> {

	@Autowired
	public OrganisationRoleService(OrganisationRoleRepository repository) {
		super(repository);
	}
}

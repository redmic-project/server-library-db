package es.redmic.db.maintenance.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.administrative.model.OrganisationType;
import es.redmic.db.maintenance.administrative.repository.OrganisationTypeRepository;
import es.redmic.models.es.maintenance.administrative.dto.OrganisationTypeDTO;

@Service
public class OrganisationTypeService extends
		ServiceDomain<OrganisationType, OrganisationTypeDTO> {

	@Autowired
	public OrganisationTypeService(OrganisationTypeRepository repository) {
		super(repository);
	}
}

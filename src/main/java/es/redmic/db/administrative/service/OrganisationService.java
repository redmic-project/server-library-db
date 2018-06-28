package es.redmic.db.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.model.Organisation;
import es.redmic.db.administrative.repository.OrganisationRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.models.es.administrative.dto.OrganisationDTO;

@Service
public class OrganisationService extends ServiceRWImpl<Organisation, OrganisationDTO> {

	@Autowired
	public OrganisationService(OrganisationRepository repository) {
		super(repository);
	}
}

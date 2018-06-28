package es.redmic.db.maintenance.point.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.point.model.InfrastructureType;
import es.redmic.db.maintenance.point.repository.InfrastructureTypeRepository;
import es.redmic.models.es.maintenance.point.dto.InfrastructureTypeDTO;


@Service
public class InfrastructureTypeService extends
		ServiceDomain<InfrastructureType, InfrastructureTypeDTO> {

	@Autowired
	public InfrastructureTypeService(InfrastructureTypeRepository repository) {
		super(repository);
	}
}

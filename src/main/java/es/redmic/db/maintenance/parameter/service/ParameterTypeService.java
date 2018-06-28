package es.redmic.db.maintenance.parameter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.parameter.model.ParameterType;
import es.redmic.db.maintenance.parameter.repository.ParameterTypeRepository;
import es.redmic.models.es.maintenance.parameter.dto.ParameterTypeDTO;

@Service
public class ParameterTypeService extends
		ServiceDomain<ParameterType, ParameterTypeDTO> {

	@Autowired
	public ParameterTypeService(ParameterTypeRepository repository) {
		super(repository);
	}
}

package es.redmic.db.maintenance.parameter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.maintenance.parameter.model.Parameter;
import es.redmic.db.maintenance.parameter.repository.ParameterRepository;
import es.redmic.models.es.maintenance.parameter.dto.ParameterDTO;

@Service
public class ParameterService extends ServiceRWImpl<Parameter, ParameterDTO> {

	@Autowired
	public ParameterService(ParameterRepository repository) {
		super(repository);
	}
}

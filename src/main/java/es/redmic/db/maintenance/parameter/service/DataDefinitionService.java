package es.redmic.db.maintenance.parameter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.maintenance.parameter.model.DataDefinition;
import es.redmic.db.maintenance.parameter.repository.DataDefinitionRepository;
import es.redmic.models.es.maintenance.parameter.dto.DataDefinitionDTO;

@Service
public class DataDefinitionService extends ServiceRWImpl<DataDefinition, DataDefinitionDTO> {

	@Autowired
	public DataDefinitionService(DataDefinitionRepository repository) {
		super(repository);
	}
}

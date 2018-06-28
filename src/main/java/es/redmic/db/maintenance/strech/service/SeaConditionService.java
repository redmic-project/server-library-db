package es.redmic.db.maintenance.strech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.strech.model.SeaCondition;
import es.redmic.db.maintenance.strech.repository.SeaConditionRepository;
import es.redmic.models.es.maintenance.strech.dto.SeaConditionDTO;

@Service
public class SeaConditionService extends
		ServiceDomain<SeaCondition, SeaConditionDTO> {

	@Autowired
	public SeaConditionService(SeaConditionRepository repository) {
		super(repository);
	}
}

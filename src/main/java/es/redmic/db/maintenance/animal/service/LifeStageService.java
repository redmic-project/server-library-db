package es.redmic.db.maintenance.animal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.animal.model.LifeStage;
import es.redmic.db.maintenance.animal.repository.LifeStageRepository;
import es.redmic.models.es.maintenance.animal.dto.LifeStageDTO;

@Service
public class LifeStageService extends
		ServiceDomain<LifeStage, LifeStageDTO> {

	@Autowired
	public LifeStageService(LifeStageRepository repository) {
		super(repository);
	}
}

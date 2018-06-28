package es.redmic.db.maintenance.areas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.maintenance.areas.model.ThematicType;
import es.redmic.db.maintenance.areas.repository.ThematicTypeRepository;
import es.redmic.models.es.maintenance.areas.dto.ThematicTypeDTO;

@Service
public class ThematicTypeService extends ServiceRWImpl<ThematicType, ThematicTypeDTO> {

	@Autowired
	public ThematicTypeService(ThematicTypeRepository repository) {
		super(repository);
	}
}

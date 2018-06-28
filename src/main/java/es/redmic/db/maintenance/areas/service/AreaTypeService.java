package es.redmic.db.maintenance.areas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.areas.model.AreaType;
import es.redmic.db.maintenance.areas.repository.AreaTypeRepository;
import es.redmic.models.es.maintenance.areas.dto.AreaTypeDTO;

@Service
public class AreaTypeService extends ServiceDomain<AreaType, AreaTypeDTO> {

	@Autowired
	public AreaTypeService(AreaTypeRepository repository) {
		super(repository);
	}
}

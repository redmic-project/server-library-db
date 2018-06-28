package es.redmic.db.maintenance.parameter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.parameter.model.UnitType;
import es.redmic.db.maintenance.parameter.repository.UnitTypeRepository;
import es.redmic.models.es.maintenance.parameter.dto.UnitTypeDTO;

@Service
public class UnitTypeService extends
		ServiceDomain<UnitType, UnitTypeDTO> {

	@Autowired
	public UnitTypeService(UnitTypeRepository repository) {
		super(repository);
	}
}

package es.redmic.db.maintenance.parameter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.maintenance.parameter.model.Unit;
import es.redmic.db.maintenance.parameter.repository.UnitRepository;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;

@Service
public class UnitService extends ServiceRWImpl<Unit, UnitDTO> {

	@Autowired
	public UnitService(UnitRepository repository) {
		super(repository);
	}
}

package es.redmic.db.maintenance.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.administrative.model.PlatformType;
import es.redmic.db.maintenance.administrative.repository.PlatformTypeRepository;
import es.redmic.models.es.maintenance.administrative.dto.PlatformTypeDTO;

@Service
public class PlatformTypeService extends
		ServiceDomain<PlatformType, PlatformTypeDTO> {

	@Autowired
	public PlatformTypeService(PlatformTypeRepository repository) {
		super(repository);
	}
}

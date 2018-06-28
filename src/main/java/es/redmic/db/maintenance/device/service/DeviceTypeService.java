package es.redmic.db.maintenance.device.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.device.model.DeviceType;
import es.redmic.db.maintenance.device.repository.DeviceTypeRepository;
import es.redmic.models.es.maintenance.device.dto.DeviceTypeDTO;

@Service
public class DeviceTypeService extends
		ServiceDomain<DeviceType, DeviceTypeDTO> {

	@Autowired
	public DeviceTypeService(DeviceTypeRepository repository) {
		super(repository);
	}
}

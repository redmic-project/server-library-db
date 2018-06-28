package es.redmic.db.maintenance.device.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.maintenance.device.model.Calibration;
import es.redmic.db.maintenance.device.repository.CalibrationRepository;
import es.redmic.models.es.maintenance.device.dto.CalibrationDTO;

@Service
public class CalibrationService extends ServiceRWImpl<Calibration, CalibrationDTO> {

	@Autowired
	public CalibrationService(CalibrationRepository repository) {
		super(repository);
	}
}

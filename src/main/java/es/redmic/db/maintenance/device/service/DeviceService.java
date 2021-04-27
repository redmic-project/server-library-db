package es.redmic.db.maintenance.device.service;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.maintenance.device.model.Calibration;
import es.redmic.db.maintenance.device.model.Device;
import es.redmic.db.maintenance.device.repository.CalibrationRepository;
import es.redmic.db.maintenance.device.repository.DeviceRepository;
import es.redmic.exception.database.DBConstraintViolationException;
import es.redmic.exception.database.DBPropertyValueException;
import es.redmic.models.es.maintenance.device.dto.CalibrationDTO;
import es.redmic.models.es.maintenance.device.dto.DeviceDTO;

@Service
public class DeviceService extends ServiceRWImpl<Device, DeviceDTO> {
	
	@Autowired
	CalibrationRepository calibrationRepository;

	@Autowired
	public DeviceService(DeviceRepository repository) {
		super(repository);
	}
	
	
	@Override
	public DeviceDTO save(DeviceDTO dto) {

		List<CalibrationDTO> calibrations = dto.getCalibrations();
		dto.setCalibrations(null);


		Device model = convertDtoToModel(dto);
		model = super.saveModel(model);
		
		if (calibrations != null)
			saveCalibrations(dto, model, calibrations);

		DeviceDTO result = convertModelToDto(model);
		publish(ADD_EVENT, result);
		return result;
	}

	public DeviceDTO update(DeviceDTO dto) {

		List<CalibrationDTO> calibrations = dto.getCalibrations();
		dto.setCalibrations(null);

		findById(dto.getId());
		Device model = convertDtoToModel(dto);
		model = super.updateModel(model);
		
		if (calibrations != null)
			updateCalibrations(dto, model, calibrations);

		DeviceDTO result = convertModelToDto(model);

		publish(UPDATE_EVENT, result);
		return result;
	}
	
	
	private void saveCalibrations(DeviceDTO a, Device b, List<CalibrationDTO> calibrations) {
		Set<Calibration> setCalibration = new HashSet<Calibration>();

		for (int i = 0; i < calibrations.size(); i++) {
			Calibration calibration = new Calibration();
			calibration = factory.getMapperFacade().map(calibrations.get(i), Calibration.class);

			calibration.setDevice(b);

			try {
				calibration = calibrationRepository.save(calibration);
			} catch (DataIntegrityViolationException e) {
				throw new DBConstraintViolationException(e);
			} catch (ConstraintViolationException e) {
				throw new DBPropertyValueException(e);
			}
			setCalibration.add(calibration);
		}

		b.setCalibrations(setCalibration);
	}

	private void updateCalibrations(DeviceDTO a, Device b, List<CalibrationDTO> calibrations) {
		Set<Calibration> setCalibration = new HashSet<Calibration>();
		List<Calibration> listCalibrations = new ArrayList<Calibration>();

		try {
			listCalibrations = calibrationRepository.findByDevice(b);
		} catch (DataIntegrityViolationException e) {
			throw new DBConstraintViolationException(e);
		} catch (ConstraintViolationException e) {
			throw new DBPropertyValueException(e);
		}

		for (int i = 0; i < calibrations.size(); i++) {
			Calibration calibration = new Calibration();
			calibration = factory.getMapperFacade().map(calibrations.get(i), Calibration.class);

			calibration.setDevice(b);

			Boolean exists = false;

			for (int n = 0; n < listCalibrations.size(); n++) {
				if (listCalibrations.get(n).getId() == calibration.getId()) {
					
					exists = true;
					listCalibrations.remove(n);
					break;
				}
			}

			try {
				if (!exists)
					calibration = calibrationRepository.save(calibration);
			} catch (DataIntegrityViolationException e) {
				throw new DBConstraintViolationException(e);
			} catch (ConstraintViolationException e) {
				throw new DBPropertyValueException(e);
			}
			setCalibration.add(calibration);
		}

		for (int n = 0; n < listCalibrations.size(); n++) {
			try {
				calibrationRepository.delete(listCalibrations.get(n));
			} catch (DataIntegrityViolationException e) {
				throw new DBConstraintViolationException(e);
			} catch (ConstraintViolationException e) {
				throw new DBPropertyValueException(e);
			}
		}

		b.setCalibrations(setCalibration);
	}
}

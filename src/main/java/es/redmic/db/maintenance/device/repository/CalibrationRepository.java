package es.redmic.db.maintenance.device.repository;

import java.util.List;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.maintenance.device.model.Calibration;
import es.redmic.db.maintenance.device.model.Device;

public interface CalibrationRepository extends BaseRepository<Calibration, Long> {

	public List<Calibration> findByDevice(Device device);
}


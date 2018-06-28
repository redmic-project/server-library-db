package es.redmic.db.geodata.tracking.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.common.service.ServiceGeo;
import es.redmic.db.geodata.tracking.platform.model.PlatformTracking;
import es.redmic.db.geodata.tracking.platform.repository.PlatformTrackingRepository;
import es.redmic.models.es.geojson.tracking.platform.dto.PlatformTrackingDTO;

@Service
public class PlatformTrackingService extends ServiceGeo<PlatformTracking, PlatformTrackingDTO> {
	
	@Autowired
	public PlatformTrackingService(PlatformTrackingRepository repository) {
		super(repository);
	}

}

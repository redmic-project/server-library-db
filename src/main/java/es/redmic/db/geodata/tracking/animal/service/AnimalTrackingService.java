package es.redmic.db.geodata.tracking.animal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.common.service.ServiceGeo;
import es.redmic.db.geodata.tracking.animal.model.AnimalTracking;
import es.redmic.db.geodata.tracking.animal.repository.AnimalTrackingRepository;
import es.redmic.models.es.geojson.tracking.animal.dto.AnimalTrackingDTO;

@Service
public class AnimalTrackingService extends ServiceGeo<AnimalTracking, AnimalTrackingDTO> {
	
	@Autowired
	public AnimalTrackingService(AnimalTrackingRepository repository) {
		super(repository);
	}
}

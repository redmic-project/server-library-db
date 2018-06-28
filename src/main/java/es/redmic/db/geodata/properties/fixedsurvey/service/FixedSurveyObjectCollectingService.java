package es.redmic.db.geodata.properties.fixedsurvey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.properties.fixedsurvey.model.FixedSurvey;
import es.redmic.db.geodata.properties.fixedsurvey.repository.FixedSurveyRepository;
import es.redmic.db.series.common.service.GeoSeriesService;
import es.redmic.models.es.geojson.geofixedstation.dto.GeoFixedObjectCollectingSeriesDTO;

@Service
public class FixedSurveyObjectCollectingService extends GeoSeriesService<FixedSurvey, GeoFixedObjectCollectingSeriesDTO> {

	@Autowired
	public FixedSurveyObjectCollectingService(FixedSurveyRepository repository) {
		super(repository);
	}
}

package es.redmic.db.geodata.properties.fixedsurvey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.properties.fixedsurvey.model.FixedSurvey;
import es.redmic.db.geodata.properties.fixedsurvey.repository.FixedSurveyRepository;
import es.redmic.db.series.common.service.GeoSeriesService;
import es.redmic.models.es.geojson.geofixedstation.dto.GeoFixedTimeSeriesDTO;

@Service
public class FixedSurveyTimeSeriesService extends GeoSeriesService<FixedSurvey, GeoFixedTimeSeriesDTO> {

	@Autowired
	public FixedSurveyTimeSeriesService(FixedSurveyRepository repository) {
		super(repository);
	}
}

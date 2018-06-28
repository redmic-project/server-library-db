package es.redmic.db.geodata.properties.fixedsurvey.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.geodata.properties.fixedsurvey.model.FixedSurvey;
import es.redmic.models.es.geojson.common.dto.FixedSurveySeriesPropertiesDTO;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;
import es.redmic.models.es.maintenance.survey.dto.FixedSurveyDTO;
import es.redmic.models.es.series.common.dto.MeasurementDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class FixedSurveySeriesMapper
		extends CustomMapper<FixedSurvey, MetaFeatureDTO<FixedSurveySeriesPropertiesDTO, ?>> {

	@Override
	public void mapAtoB(FixedSurvey a, MetaFeatureDTO<FixedSurveySeriesPropertiesDTO, ?> b, MappingContext context) {

		FixedSurveyDTO site = new FixedSurveyDTO();
		mapperFacade.map(a, site);

		FixedSurveySeriesPropertiesDTO properties = new FixedSurveySeriesPropertiesDTO();
		properties.setSite(site);
		b.setProperties(properties);

		List<MeasurementDTO> measurementList = mapperFacade.mapAsList(a.getFixedMeasurement(), MeasurementDTO.class);

		b.getProperties().setMeasurements(measurementList);
		b.getProperties().setActivityId(a.getActivity().getId().toString());
		b.setId(a.getId());
		b.setUuid(a.getUuid());
	}

	@Override
	public void mapBtoA(MetaFeatureDTO<FixedSurveySeriesPropertiesDTO, ?> b, FixedSurvey a, MappingContext context) {

		mapperFacade.map(b.getProperties().getSite(), a);
		a.setGeometry(b.getGeometry());
		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}
}
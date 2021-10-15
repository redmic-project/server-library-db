package es.redmic.db.geodata.properties.fixedsurvey.mapper;

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

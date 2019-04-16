package es.redmic.db.series.timeseries.mapper;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.db.geodata.properties.fixedsurvey.repository.FixedMeasurementRepository;
import es.redmic.db.maintenance.parameter.model.DataDefinition;
import es.redmic.db.series.common.mapper.SeriesBaseMapper;
import es.redmic.db.series.timeseries.model.TimeSeries;
import es.redmic.models.es.series.timeseries.dto.TimeSeriesDTO;
import ma.glasnost.orika.MappingContext;

@Component
public class TimeSeriesMapper extends SeriesBaseMapper<TimeSeries, TimeSeriesDTO> {

	@Autowired
	FixedMeasurementRepository measurementRepository;

	@Override
	public void mapAtoB(TimeSeries a, TimeSeriesDTO b, MappingContext context) {

		super.mapAtoB(a, b, context);
		b.setDataDefinition(a.getFixedMeasurement().getDataDefinition().getId());

		b.set_grandparentId(a.getFixedMeasurement().getFixedSurvey().getActivity().getId().toString());
		b.set_parentId(a.getFixedMeasurement().getFixedSurvey().getUuid());
	}

	@Override
	public void mapBtoA(TimeSeriesDTO a, TimeSeries b, MappingContext context) {

		super.mapBtoA(a, b, context);
		b.setFixedMeasurement(getMeasurement(a.getDataDefinition()));
	}

	private FixedMeasurement getMeasurement(Long dataDefinitionId) {

		DataDefinition dataDefinition = new DataDefinition();
		dataDefinition.setId(dataDefinitionId);

		return measurementRepository.findByDataDefinition(dataDefinition);
	}
}

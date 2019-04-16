package es.redmic.db.series.timeseries.service;

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
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.db.series.common.service.RWBaseSeriesService;
import es.redmic.db.series.timeseries.model.TimeSeries;
import es.redmic.db.series.timeseries.repository.TimeSeriesRepository;
import es.redmic.models.es.series.timeseries.dto.TimeSeriesDTO;

@Service
public class TimeSeriesService extends RWBaseSeriesService<TimeSeries, TimeSeriesDTO> {
	
	@Autowired
	public TimeSeriesService(TimeSeriesRepository repository) {
		super(repository);
	}
	
	protected TimeSeries setFixedMeasurement(TimeSeries model, FixedMeasurement stationMeasurement) {
		model.setFixedMeasurement(stationMeasurement);
		return model;
	}

	@Override
	protected TimeSeries setReferences(TimeSeries model, TimeSeriesDTO dto) {
		return model;
	}
}

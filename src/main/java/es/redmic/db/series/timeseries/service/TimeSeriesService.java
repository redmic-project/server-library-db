package es.redmic.db.series.timeseries.service;

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
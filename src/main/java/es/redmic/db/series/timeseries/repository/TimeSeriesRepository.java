package es.redmic.db.series.timeseries.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.series.timeseries.model.TimeSeries;

public interface TimeSeriesRepository extends BaseRepository<TimeSeries, Long> {
	
	@Query(value = "SELECT t FROM TimeSeries t WHERE t.id between :start and :end")
	Page<TimeSeries> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

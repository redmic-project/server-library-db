package es.redmic.db.geodata.properties.fixedsurvey.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.db.geodata.common.repository.RepositoryGeo;
import es.redmic.db.geodata.properties.fixedsurvey.model.FixedSurvey;

public interface FixedSurveyRepository extends RepositoryGeo<FixedSurvey, Long> {

	@Query("SELECT s FROM FixedSurvey s WHERE s.prefixtype LIKE 'ft' and s.id between :start and :end")
	public Page<FixedSurvey> findTimeSeriesSurvey(@Param("start") long start, @Param("end") long end,
			Pageable pageable);

	@Query("SELECT s FROM FixedSurvey s WHERE s.prefixtype LIKE 'oc' and s.id between :start and :end")
	public Page<FixedSurvey> findObjectCollectingSeriesSurvey(@Param("start") long start, @Param("end") long end,
			Pageable pageable);
}

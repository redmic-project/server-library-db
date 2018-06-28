package es.redmic.db.geodata.tracking.animal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.db.geodata.common.repository.RepositoryGeo;
import es.redmic.db.geodata.tracking.animal.model.AnimalTracking;

public interface AnimalTrackingRepository extends RepositoryGeo<AnimalTracking, Long> {

	@Query(value = "SELECT a FROM AnimalTracking a WHERE a.id between :start and :end")
	Page<AnimalTracking> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

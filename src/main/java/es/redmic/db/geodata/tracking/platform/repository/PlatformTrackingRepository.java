package es.redmic.db.geodata.tracking.platform.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.db.geodata.common.repository.RepositoryGeo;
import es.redmic.db.geodata.tracking.platform.model.PlatformTracking;

public interface PlatformTrackingRepository extends RepositoryGeo<PlatformTracking, Long>  {

	@Query(value = "SELECT p FROM PlatformTracking p WHERE p.id between :start and :end")
	Page<PlatformTracking> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

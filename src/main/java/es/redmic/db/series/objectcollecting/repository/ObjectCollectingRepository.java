package es.redmic.db.series.objectcollecting.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.series.objectcollecting.model.ObjectCollecting;

public interface ObjectCollectingRepository extends BaseRepository<ObjectCollecting, Long> {
	
	@Query(value = "SELECT o FROM ObjectCollecting o WHERE o.id between :start and :end")
	Page<ObjectCollecting> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

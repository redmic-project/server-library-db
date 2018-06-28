package es.redmic.db.geodata.area.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.redmic.db.geodata.area.model.Area;
import es.redmic.db.geodata.common.repository.RepositoryGeo;

@Repository
public interface AreaRepository extends RepositoryGeo<Area, Long> {

	@Query(value = "SELECT a FROM Area a WHERE a.id between :start and :end")
	Page<Area> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

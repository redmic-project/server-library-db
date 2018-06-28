package es.redmic.db.geodata.isolines.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.db.geodata.common.repository.RepositoryGeo;
import es.redmic.db.geodata.isolines.model.Isolines;

public interface IsolinesRepository extends RepositoryGeo<Isolines, Long> {

	@Query(value = "SELECT i FROM Isolines i WHERE i.id between :start and :end")
	Page<Isolines> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

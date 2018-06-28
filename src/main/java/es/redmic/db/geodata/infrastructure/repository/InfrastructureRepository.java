package es.redmic.db.geodata.infrastructure.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.db.geodata.common.repository.RepositoryGeo;
import es.redmic.db.geodata.infrastructure.model.Infrastructure;

public interface InfrastructureRepository extends RepositoryGeo<Infrastructure, Long> {

	@Query(value = "SELECT i FROM Infrastructure i WHERE i.id between :start and :end")
	Page<Infrastructure> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

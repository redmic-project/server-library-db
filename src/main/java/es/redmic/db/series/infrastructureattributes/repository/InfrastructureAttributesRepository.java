package es.redmic.db.series.infrastructureattributes.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.series.infrastructureattributes.model.InfrastructureAttributes;

public interface InfrastructureAttributesRepository extends BaseRepository<InfrastructureAttributes, Long> {

	@Query(value = "SELECT i FROM InfrastructureAttributes i WHERE i.id between :start and :end")
	Page<InfrastructureAttributes> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

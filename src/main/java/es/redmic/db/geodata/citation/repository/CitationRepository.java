package es.redmic.db.geodata.citation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.db.administrative.taxonomy.model.Misidentification;
import es.redmic.db.geodata.citation.model.Citation;
import es.redmic.db.geodata.common.repository.RepositoryGeo;

public interface CitationRepository extends RepositoryGeo<Citation, Long> {

	List<Citation> findByMisidentification(Misidentification misidentification);

	@Query(value = "SELECT c FROM Citation c WHERE c.id between :start and :end")
	Page<Citation> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

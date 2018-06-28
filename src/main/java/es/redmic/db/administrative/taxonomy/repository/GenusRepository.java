package es.redmic.db.administrative.taxonomy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.taxonomy.model.Genus;

public interface GenusRepository extends BaseRepository<Genus, Long> {
	
	@Query(value = "SELECT t FROM Genus t WHERE t.validas IS NOT NULL")
	Page<Genus> findGenusWithValidAs(Pageable pageable);

}

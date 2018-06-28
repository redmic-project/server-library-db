package es.redmic.db.administrative.taxonomy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.taxonomy.model.AbstractSpecies;

public interface SpeciesRepository extends BaseRepository<AbstractSpecies, Long> {

	@Query(value = "SELECT t FROM Taxon t WHERE t.rank.id >= 10 ORDER BY t.rank.id ASC, t.id ASC, ?#{#pageable}")
	Page<AbstractSpecies> findSpecies(Pageable pageable);

	@Query(value = "SELECT t FROM Taxon t WHERE t.rank.id >= 10 AND t.validas IS NOT NULL ORDER BY t.rank.id ASC, ?#{#pageable}")
	Page<AbstractSpecies> findSpeciesWithValidAs(Pageable pageable);
}

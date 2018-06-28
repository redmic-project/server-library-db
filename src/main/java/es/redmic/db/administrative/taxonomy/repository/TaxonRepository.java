package es.redmic.db.administrative.taxonomy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.taxonomy.model.Taxon;


public interface TaxonRepository extends BaseRepository<Taxon, Long> {

	@Query(value = "SELECT t FROM Taxon t WHERE t.rank.id < 10 ORDER BY t.rank.id ASC, t.validas.id DESC, ?#{#pageable}")
	Page<Taxon> findTaxons(Pageable pageable);
}

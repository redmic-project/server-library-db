package es.redmic.db.administrative.taxonomy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.taxonomy.model.Family;

public interface FamilyRepository extends BaseRepository<Family, Long> {
	
	@Query(value = "SELECT t FROM Family t WHERE t.validas IS NOT NULL")
	Page<Family> findFamilyWithValidAs(Pageable pageable);

}

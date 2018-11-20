package es.redmic.db.administrative.taxonomy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.taxonomy.model.Orderr;

public interface OrderRepository extends BaseRepository<Orderr, Long> {
	
	@Query(value = "SELECT t FROM Orderr t WHERE t.validas IS NOT NULL")
	Page<Orderr> findOrderWithValidAs(Pageable pageable);

}

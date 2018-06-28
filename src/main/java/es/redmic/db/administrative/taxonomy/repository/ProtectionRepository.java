package es.redmic.db.administrative.taxonomy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.taxonomy.model.Peculiarity;

public interface ProtectionRepository extends BaseRepository<Peculiarity, Long> {

	@Query("select p from Peculiarity p where p.taxon.id = :id")
	public Peculiarity findOneByTaxon(@Param("id") Long taxonId);

}

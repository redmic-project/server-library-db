package es.redmic.db.administrative.taxonomy.repository;

import java.util.List;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.taxonomy.model.Animal;
import es.redmic.db.administrative.taxonomy.model.Recovery;

public interface RecoveryRepository extends BaseRepository<Recovery, Long> {

	public List<Recovery> findByAnimal(Animal animal);
}
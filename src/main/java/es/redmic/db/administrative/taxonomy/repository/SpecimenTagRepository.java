package es.redmic.db.administrative.taxonomy.repository;

import java.util.List;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.taxonomy.model.Animal;
import es.redmic.db.administrative.taxonomy.model.SpecimenTag;

public interface SpecimenTagRepository extends BaseRepository<SpecimenTag, Long> {

	public List<SpecimenTag> findByAnimal(Animal animal);
}
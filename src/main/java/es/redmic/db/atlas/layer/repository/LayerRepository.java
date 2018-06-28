package es.redmic.db.atlas.layer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.atlas.layer.model.Layer;

@Repository
public interface LayerRepository extends BaseRepository<Layer, Long> {

	@Query("SELECT l FROM Layer l WHERE l.name = :name AND l.urlSource = :urlSource")
	Layer findByNameAndUrlSource(@Param("name") String name, @Param("urlSource") String urlSource);
}

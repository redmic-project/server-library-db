package es.redmic.db.geodata.common.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.repository.NoRepositoryBean;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.geodata.common.model.GeoDataModel;

@NoRepositoryBean
public interface RepositoryGeo<TModel extends GeoDataModel, TKey extends Serializable> extends BaseRepository<TModel, TKey> {

	TModel findByUuid(UUID uuid);
}

package es.redmic.db.common.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.common.model.UuidModel;

@NoRepositoryBean
public interface UuidRepository<TModel extends UuidModel, TKey extends Serializable> extends BaseRepository<TModel, Long> {

	TModel findByUuid(String uuid);
}
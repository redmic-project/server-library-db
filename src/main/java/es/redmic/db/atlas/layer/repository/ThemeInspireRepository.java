package es.redmic.db.atlas.layer.repository;

import org.springframework.stereotype.Repository;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.atlas.layer.model.ThemeInspire;

@Repository
public interface ThemeInspireRepository extends BaseRepository<ThemeInspire, Long> {
}

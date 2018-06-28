package es.redmic.db.atlas.layer.repository;

import org.springframework.stereotype.Repository;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.atlas.layer.model.Protocols;

@Repository
public interface ProtocolsRepository extends BaseRepository<Protocols, Long> {

}

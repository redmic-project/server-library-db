package es.redmic.db.administrative.repository;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.model.Document;

public interface DocumentRepository extends BaseRepository<Document, Long> {
	
	Document findByCode(String code);
}

package es.redmic.db.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.model.Document;
import es.redmic.db.administrative.repository.DocumentRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.models.es.administrative.dto.DocumentDTO;

@Service
public class DocumentService extends ServiceRWImpl<Document, DocumentDTO> {

	DocumentRepository repository;

	@Autowired
	public DocumentService(DocumentRepository repository) {
		super(repository);

		this.repository = repository;
	}

	public DocumentDTO findByCode(String code) {

		return convertModelToDto(repository.findByCode(code));
	}
}

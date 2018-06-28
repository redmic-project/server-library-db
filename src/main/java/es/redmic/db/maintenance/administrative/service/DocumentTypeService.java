package es.redmic.db.maintenance.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.administrative.model.DocumentType;
import es.redmic.db.maintenance.administrative.repository.DocumentTypeRepository;
import es.redmic.models.es.maintenance.administrative.dto.DocumentTypeDTO;

@Service
public class DocumentTypeService extends
		ServiceDomain<DocumentType, DocumentTypeDTO> {

	@Autowired
	public DocumentTypeService(DocumentTypeRepository repository) {
		super(repository);
	}
}

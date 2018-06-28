package es.redmic.db.maintenance.qualifiers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.maintenance.qualifiers.model.AttributeType;
import es.redmic.db.maintenance.qualifiers.repository.AttributeTypeRepository;
import es.redmic.models.es.maintenance.qualifiers.dto.AttributeTypeDTO;

@Service
public class AttributeTypeService extends ServiceRWImpl<AttributeType, AttributeTypeDTO> {

	@Autowired
	public AttributeTypeService(AttributeTypeRepository repository) {
		super(repository);
	}
}

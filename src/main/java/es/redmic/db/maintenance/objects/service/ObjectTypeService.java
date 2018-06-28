package es.redmic.db.maintenance.objects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.maintenance.objects.model.ObjectType;
import es.redmic.db.maintenance.objects.repository.ObjectTypeRepository;
import es.redmic.models.es.maintenance.objects.dto.ObjectTypeDTO;

@Service
public class ObjectTypeService extends ServiceRWImpl<ObjectType, ObjectTypeDTO> {

	@Autowired
	public ObjectTypeService(ObjectTypeRepository repository) {
		super(repository);
	}
}
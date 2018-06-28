package es.redmic.db.maintenance.toponym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.toponym.model.ToponymType;
import es.redmic.db.maintenance.toponym.repository.ToponymTypeRepository;
import es.redmic.models.es.maintenance.toponym.dto.ToponymTypeDTO;

@Service
public class ToponymTypeService extends
		ServiceDomain<ToponymType, ToponymTypeDTO> {

	@Autowired
	public ToponymTypeService(ToponymTypeRepository repository) {
		super(repository);
	}
}

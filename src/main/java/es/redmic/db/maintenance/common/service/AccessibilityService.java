package es.redmic.db.maintenance.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.common.model.Accessibility;
import es.redmic.db.maintenance.common.repository.AccessibilityRepository;
import es.redmic.models.es.maintenance.common.dto.AccessibilityDTO;

@Service
public class AccessibilityService extends
		ServiceDomain<Accessibility, AccessibilityDTO> {

	@Autowired
	public AccessibilityService(AccessibilityRepository repository) {
		super(repository);
	}
}

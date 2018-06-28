package es.redmic.db.maintenance.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.administrative.model.Scope;
import es.redmic.db.maintenance.administrative.repository.ScopeRepository;
import es.redmic.models.es.maintenance.administrative.dto.ScopeDTO;

@Service
public class ScopeService extends ServiceDomain<Scope, ScopeDTO> {

	@Autowired
	public ScopeService(ScopeRepository repository) {
		super(repository);
	}
}

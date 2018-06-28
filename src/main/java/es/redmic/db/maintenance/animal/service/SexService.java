package es.redmic.db.maintenance.animal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.animal.model.Sex;
import es.redmic.db.maintenance.animal.repository.SexRepository;
import es.redmic.models.es.maintenance.animal.dto.SexDTO;

@Service
public class SexService extends
		ServiceDomain<Sex, SexDTO> {

	@Autowired
	public SexService(SexRepository repository) {
		super(repository);
	}
}

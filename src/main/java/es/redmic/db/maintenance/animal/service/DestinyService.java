package es.redmic.db.maintenance.animal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.animal.model.Destiny;
import es.redmic.db.maintenance.animal.repository.DestinyRepository;
import es.redmic.models.es.maintenance.animal.dto.DestinyDTO;

@Service
public class DestinyService extends
		ServiceDomain<Destiny, DestinyDTO> {

	@Autowired
	public DestinyService(DestinyRepository repository) {
		super(repository);
	}
}

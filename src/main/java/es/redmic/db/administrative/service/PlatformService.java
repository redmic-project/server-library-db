package es.redmic.db.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.model.Platform;
import es.redmic.db.administrative.repository.PlatformRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.models.es.administrative.dto.PlatformDTO;

@Service
public class PlatformService extends ServiceRWImpl<Platform, PlatformDTO> {

	@Autowired
	public PlatformService(PlatformRepository repository) {
		super(repository);
	}
}

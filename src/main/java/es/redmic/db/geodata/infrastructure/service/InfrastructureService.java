package es.redmic.db.geodata.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.common.service.ServiceGeo;
import es.redmic.db.geodata.infrastructure.model.Infrastructure;
import es.redmic.db.geodata.infrastructure.repository.InfrastructureRepository;
import es.redmic.models.es.geojson.infrastructure.dto.InfrastructureDTO;

@Service
public class InfrastructureService extends ServiceGeo<Infrastructure, InfrastructureDTO> {
	
	@Autowired
	public InfrastructureService(InfrastructureRepository repository) {
		super(repository);
	}
}

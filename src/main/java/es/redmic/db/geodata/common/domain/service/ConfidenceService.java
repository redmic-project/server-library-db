package es.redmic.db.geodata.common.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.geodata.common.domain.model.Confidence;
import es.redmic.db.geodata.common.domain.repository.ConfidenceRepository;
import es.redmic.models.es.geojson.common.domain.dto.ConfidenceDTO;

@Service
public class ConfidenceService extends
		ServiceDomain<Confidence, ConfidenceDTO> {

	@Autowired
	public ConfidenceService(ConfidenceRepository repository) {
		super(repository);
	}
}

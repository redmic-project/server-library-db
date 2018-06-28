package es.redmic.db.geodata.citation.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Misidentification;
import es.redmic.db.geodata.citation.model.Citation;
import es.redmic.db.geodata.citation.repository.CitationRepository;
import es.redmic.db.geodata.common.service.ServiceGeo;
import es.redmic.models.es.geojson.citation.dto.CitationDTO;

@Service
public class CitationService extends ServiceGeo<Citation, CitationDTO> {
	
	CitationRepository repository;

	@Autowired
	public CitationService(CitationRepository repository) {
		super(repository);
		this.repository = repository;
	}
	
	public List<Citation> findByMisidentification(Misidentification misidentification) {
		return repository.findByMisidentification(misidentification);
	}
	
	public Citation findByUuid(UUID uuid) {
		return repository.findByUuid(uuid);
	}
}
package es.redmic.db.administrative.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Subfilum;
import es.redmic.db.administrative.taxonomy.repository.SubfilumRepository;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;

@Service
public class SubfilumService extends TaxonAbstractService<Subfilum, TaxonDTO> {

	@Autowired
	public SubfilumService(SubfilumRepository repository) {
		super(repository, 5L);
	}
}

package es.redmic.db.administrative.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Genus;
import es.redmic.db.administrative.taxonomy.repository.GenusRepository;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;

@Service
public class GenusService extends TaxonAbstractService<Genus, TaxonDTO> {

	@Autowired
	public GenusService(GenusRepository repository) {
		super(repository, 9L);
	}
}

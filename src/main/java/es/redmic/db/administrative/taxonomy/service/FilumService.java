package es.redmic.db.administrative.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Filum;
import es.redmic.db.administrative.taxonomy.repository.FilumRepository;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;

@Service
public class FilumService extends TaxonAbstractService<Filum, TaxonDTO> {

	@Autowired
	public FilumService(FilumRepository repository) {
		super(repository, 3L);
	}
}

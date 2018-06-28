package es.redmic.db.administrative.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Kingdom;
import es.redmic.db.administrative.taxonomy.repository.KingdomRepository;
import es.redmic.models.es.administrative.taxonomy.dto.KingdomDTO;

@Service
public class KingdomService extends TaxonAbstractService<Kingdom, KingdomDTO> {

	@Autowired
	public KingdomService(KingdomRepository repository) {
		super(repository, 1L);
	}
}

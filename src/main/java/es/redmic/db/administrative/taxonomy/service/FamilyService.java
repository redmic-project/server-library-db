package es.redmic.db.administrative.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Family;
import es.redmic.db.administrative.taxonomy.repository.FamilyRepository;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;

@Service
public class FamilyService extends TaxonAbstractService<Family, TaxonDTO> {

	@Autowired
	public FamilyService(FamilyRepository repository) {
		super(repository, 8L);
	}
}

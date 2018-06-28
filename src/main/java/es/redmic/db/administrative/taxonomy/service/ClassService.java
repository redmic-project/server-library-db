package es.redmic.db.administrative.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Classs;
import es.redmic.db.administrative.taxonomy.repository.ClassRepository;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;

@Service
public class ClassService extends TaxonAbstractService<Classs, TaxonDTO> {


	@Autowired
	public ClassService(ClassRepository repository) {
		super(repository, 6L);
	}
}

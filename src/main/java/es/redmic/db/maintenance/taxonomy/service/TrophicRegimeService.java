package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.TrophicRegime;
import es.redmic.db.maintenance.taxonomy.repository.TrophicRegimeRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.TrophicRegimeDTO;

@Service
public class TrophicRegimeService extends
		ServiceDomain<TrophicRegime, TrophicRegimeDTO> {

	@Autowired
	public TrophicRegimeService(TrophicRegimeRepository repository) {
		super(repository);
	}
}

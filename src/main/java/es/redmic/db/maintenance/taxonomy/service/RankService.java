package es.redmic.db.maintenance.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.taxonomy.model.Rank;
import es.redmic.db.maintenance.taxonomy.repository.RankRepository;
import es.redmic.models.es.maintenance.taxonomy.dto.RankDTO;

@Service
public class RankService extends ServiceDomain<Rank, RankDTO> {

	@Autowired
	public RankService(RankRepository repository) {
		super(repository);
	}
}

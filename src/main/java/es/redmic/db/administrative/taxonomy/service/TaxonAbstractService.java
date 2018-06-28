package es.redmic.db.administrative.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.taxonomy.model.Taxon;
import es.redmic.db.administrative.taxonomy.repository.TaxonRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.exception.common.ExceptionType;
import es.redmic.exception.common.InternalException;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonWithOutParentDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.RankDTO;

public abstract class TaxonAbstractService<TModel extends Taxon, TDTO extends TaxonWithOutParentDTO>
		extends ServiceRWImpl<TModel, TDTO> {

	Long rankId;

	@Autowired
	TaxonRepository taxonRepository;

	@Autowired
	public TaxonAbstractService(BaseRepository<TModel, Long> repository, Long rankId) {
		super(repository);
		this.rankId = rankId;
	}

	@Autowired
	public TaxonAbstractService(BaseRepository<TModel, Long> repository) {
		super(repository);
	}

	@Override
	public TDTO save(TDTO dto) {

		return super.save(setRank(dto));
	}

	protected TDTO setRank(TDTO dto) {
		if (this.rankId == null && dto.getRank() == null) {
			LOGGER.debug("RankId no seteado, imposible guardar un taxon sin rankId");
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION);
		}
		if (dto.getRank() == null) {
			RankDTO rank = new RankDTO();
			rank.setId(rankId);
			dto.setRank(rank);
		} else {
			rankId = dto.getRank().getId();
		}
		return dto;
	}
}
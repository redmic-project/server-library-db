package es.redmic.db.administrative.taxonomy.service;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

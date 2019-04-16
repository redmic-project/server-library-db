package es.redmic.db.series.common.mapper;

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

import es.redmic.db.maintenance.quality.model.QFlag;
import es.redmic.db.maintenance.quality.model.VFlag;
import es.redmic.db.maintenance.quality.repository.QFlagRepository;
import es.redmic.db.maintenance.quality.repository.VFlagRepository;
import es.redmic.db.series.common.model.SeriesBase;
import es.redmic.exception.database.DBNotFoundException;
import es.redmic.models.es.series.common.dto.SeriesCommonDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public abstract class SeriesBaseMapper<TModel extends SeriesBase, TDTO extends SeriesCommonDTO>
		extends CustomMapper<TModel, TDTO> {

	@Autowired
	QFlagRepository qFlagRepository;

	@Autowired
	VFlagRepository vFlagRepository;

	@Override
	public void mapAtoB(SeriesBase a, SeriesCommonDTO b, MappingContext context) {

		b.setQFlag(a.getQFlag().getId());
		b.setVFlag(a.getVFlag().getId());
	}

	@Override
	public void mapBtoA(SeriesCommonDTO a, SeriesBase b, MappingContext context) {

		b.setQFlag(getQFlag(a.getQFlag()));
		b.setVFlag(getVFlag(a.getVFlag()));
	}

	private QFlag getQFlag(Character qFlagId) {

		QFlag qFlag = qFlagRepository.findById(qFlagId).get();
		if (qFlag == null)
			throw new DBNotFoundException("qFlag", qFlagId.toString());
		return qFlag;
	}

	private VFlag getVFlag(Character vFlagId) {
		VFlag vFlag = vFlagRepository.findById(vFlagId).get();
		if (vFlag == null)
			throw new DBNotFoundException("vFlag", vFlagId.toString());
		return vFlag;
	}
}

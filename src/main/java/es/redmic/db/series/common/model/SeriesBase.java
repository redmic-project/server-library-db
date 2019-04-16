package es.redmic.db.series.common.model;

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

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.maintenance.quality.model.QFlag;
import es.redmic.db.maintenance.quality.model.VFlag;

@MappedSuperclass
public abstract class SeriesBase extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "qflagid")
	private QFlag qFlag;

	@ManyToOne
	@JoinColumn(name = "vflagid")
	private VFlag vFlag;

	public QFlag getQFlag() {
		return this.qFlag;
	}

	public void setQFlag(QFlag qFlag) {
		this.qFlag = qFlag;
	}

	public VFlag getVFlag() {
		return this.vFlag;
	}

	public void setVFlag(VFlag vFlag) {
		this.vFlag = vFlag;
	}
}

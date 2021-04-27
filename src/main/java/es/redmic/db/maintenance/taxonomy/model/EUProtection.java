package es.redmic.db.maintenance.taxonomy.model;

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

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.taxonomy.model.Peculiarity;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the eudirective database table.
 * 
 */
@Entity
@Table(name = "euprotection")
@NamedQuery(name = "EUProtection.findAll", query = "SELECT e FROM EUProtection e")
public class EUProtection extends DomainModel {

	// bi-directional many-to-one association to Protection
	@OneToMany(mappedBy = "euprotection")
	private List<Peculiarity> protections;

	public EUProtection() {
		super();
	}

	public List<Peculiarity> getProtections() {
		return this.protections;
	}

	public void setProtections(List<Peculiarity> protections) {
		this.protections = protections;
	}

	public Peculiarity addProtection(Peculiarity protection) {
		getProtections().add(protection);
		protection.setEuProtection(this);

		return protection;
	}

	public Peculiarity removeProtection(Peculiarity protection) {
		getProtections().remove(protection);
		protection.setEuProtection(null);

		return protection;
	}
}

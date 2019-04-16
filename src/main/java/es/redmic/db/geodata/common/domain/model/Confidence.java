package es.redmic.db.geodata.common.domain.model;

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
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;
import es.redmic.db.geodata.citation.model.Citation;

/**
 * The persistent class for the confidence database table.
 * 
 */
@Entity
@Table(name = "confidence")
@NamedQuery(name = "Confidence.findAll", query = "SELECT c FROM Confidence c")
public class Confidence extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public Confidence() {
		super();
	}

	// bi-directional many-to-one association to Collect
	@OneToMany(mappedBy = "confidence")
	private Set<Citation> citations;


	public Set<Citation> getCitations() {
		return this.citations;
	}

	public void setCitations(Set<Citation> citations) {
		this.citations = citations;
	}

	public Citation addCitations(Citation citations) {
		getCitations().add(citations);
		citations.setConfidence(this);

		return citations;
	}

	public Citation removeCitations(Citation citations) {
		getCitations().remove(citations);
		citations.setConfidence(null);

		return citations;
	}
}

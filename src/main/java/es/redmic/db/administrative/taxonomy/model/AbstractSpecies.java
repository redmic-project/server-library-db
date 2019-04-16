package es.redmic.db.administrative.taxonomy.model;

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

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import es.redmic.db.geodata.citation.model.Citation;

@Entity
public class AbstractSpecies extends Taxon {

	public AbstractSpecies() {
		super();
	}
	
	private String groupicon;

	private String image;

	// bi-directional one-to-one association to Protection
	@OneToOne(mappedBy = "taxon", cascade = { CascadeType.ALL })
	private Peculiarity protection;

	@OneToMany(mappedBy = "taxon")
	private Set<Citation> citations;

	public String getGroupIcon() {
		return this.groupicon;
	}

	public void setGroupIcon(String groupicon) {
		this.groupicon = groupicon;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Peculiarity getProtection() {
		return this.protection;
	}

	public void setProtection(Peculiarity protection) {
		protection.setSpecies(this);
		this.protection = protection;
	}

	public Set<Citation> getCitations() {
		return this.citations;
	}

	public void setCitations(Set<Citation> citations) {
		this.citations = citations;
	}

	public Citation addCitation(Citation citation) {
		getCitations().add(citation);
		citation.setTaxon((Taxon) this);

		return citation;
	}

	public Citation removeCitation(Citation citation) {
		getCitations().remove(citation);
		citation.setTaxon(null);
		return citation;
	}

}

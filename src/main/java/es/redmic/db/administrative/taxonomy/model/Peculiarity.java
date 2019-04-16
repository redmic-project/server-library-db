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

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.administrative.model.Document;
import es.redmic.db.maintenance.taxonomy.model.CanaryProtection;
import es.redmic.db.maintenance.taxonomy.model.EUProtection;
import es.redmic.db.maintenance.taxonomy.model.Ecology;
import es.redmic.db.maintenance.taxonomy.model.Endemicity;
import es.redmic.db.maintenance.taxonomy.model.Interest;
import es.redmic.db.maintenance.taxonomy.model.Origin;
import es.redmic.db.maintenance.taxonomy.model.Permanence;
import es.redmic.db.maintenance.taxonomy.model.SpainProtection;
import es.redmic.db.maintenance.taxonomy.model.TrophicRegime;

/**
 * The persistent class for the protection database table.
 * 
 */
@Table(name = "peculiarity")
@Entity
@NamedQuery(name = "Peculiarity.findAll", query = "SELECT p FROM Peculiarity p")
public class Peculiarity extends LongModel {
	
	private String popularnames;

	// bi-directional one-to-one association to Taxon
	@OneToOne
	@JoinColumn(name = "taxonid")
	private Taxon taxon;

	// bi-directional many-to-one association to EUDirective
	@ManyToOne
	@JoinColumn(name = "euprotectionid")
	private EUProtection euprotection;

	// bi-directional many-to-one association to SpainProtection
	@ManyToOne
	@JoinColumn(name = "spainprotectionid")
	private SpainProtection spainprotection;

	// bi-directional many-to-one association to CanaryProtection
	@ManyToOne
	@JoinColumn(name = "canaryprotectionid")
	private CanaryProtection canaryprotection;

	/* Documentos */

	// bi-directional many-to-one association to Document
	@ManyToOne
	@JoinColumn(name = "eudirective")
	private Document eudirective;

	// bi-directional many-to-one association to Document
	@ManyToOne
	@JoinColumn(name = "spaincatalogue")
	private Document spaincatalogue;

	// bi-directional many-to-one association to Document
	@ManyToOne
	@JoinColumn(name = "canarycatalogue")
	private Document canarycatalogue;

	// bi-directional many-to-one association to Ecology
	@ManyToOne
	@JoinColumn(name = "ecologyid")
	private Ecology ecology;

	// bi-directional many-to-one association to Endemicity
	@ManyToOne
	@JoinColumn(name = "endemicityid")
	private Endemicity endemicity;

	// bi-directional many-to-one association to Interest
	@ManyToOne
	@JoinColumn(name = "interestid")
	private Interest interest;

	// bi-directional many-to-one association to Origin
	@ManyToOne
	@JoinColumn(name = "originid")
	private Origin origin;

	// bi-directional many-to-one association to Permanence
	@ManyToOne
	@JoinColumn(name = "permanenceid")
	private Permanence permanence;
	
	// bi-directional many-to-one association to Permanence
	@ManyToOne
	@JoinColumn(name = "trophicregimeid")
	private TrophicRegime trophicregime;

	public Peculiarity() {
		super();
	}
	
	public String getPopularNames() {
		return popularnames;
	}

	public void setPopularNames(String popularnames) {
		this.popularnames = popularnames;
	}

	public Taxon getSpecies() {
		return this.taxon;
	}

	public void setSpecies(Taxon taxon) {
		this.taxon = taxon;
	}

	public CanaryProtection getCanaryProtection() {
		return this.canaryprotection;
	}

	public void setCanaryProtection(CanaryProtection canaryprotection) {
		this.canaryprotection = canaryprotection;
	}

	public Document getCanaryCatalogue() {
		return this.canarycatalogue;
	}

	public void setCanaryCatalogue(Document canarycatalogue) {
		this.canarycatalogue = canarycatalogue;
	}

	public Document getSpainCatalogue() {
		return this.spaincatalogue;
	}

	public void setSpainCatalogue(Document spaincatalogue) {
		this.spaincatalogue = spaincatalogue;
	}

	public EUProtection getEuProtection() {
		return this.euprotection;
	}

	public void setEuProtection(EUProtection euprotection) {
		this.euprotection = euprotection;
	}

	public Ecology getEcology() {
		return this.ecology;
	}

	public void setEcology(Ecology ecology) {
		this.ecology = ecology;
	}

	public Endemicity getEndemicity() {
		return this.endemicity;
	}

	public void setEndemicity(Endemicity endemicity) {
		this.endemicity = endemicity;
	}

	public Document getEuDirective() {
		return this.eudirective;
	}

	public void setEuDirective(Document eudirective) {
		this.eudirective = eudirective;
	}

	public Interest getInterest() {
		return this.interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public Origin getOrigin() {
		return this.origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Permanence getPermanence() {
		return this.permanence;
	}

	public void setPermanence(Permanence permanence) {
		this.permanence = permanence;
	}

	public SpainProtection getSpainProtection() {
		return this.spainprotection;
	}

	public void setSpainProtection(SpainProtection spainprotection) {
		this.spainprotection = spainprotection;
	}

	public TrophicRegime getTrophicRegime() {
		return trophicregime;
	}

	public void setTrophicRegime(TrophicRegime trophicregime) {
		this.trophicregime = trophicregime;
	}
}

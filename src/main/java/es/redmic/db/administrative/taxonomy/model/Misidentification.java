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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.administrative.model.Document;

@Entity
@Table(name = "misidentification")
@NamedQuery(name = "Misidentification.findAll", query = "SELECT m FROM Misidentification m")
public class Misidentification extends LongModel {

	// bi-directional many-to-one association to Activitytype
	@ManyToOne
	@JoinColumn(name = "taxonid", nullable = false)
	private Taxon taxon;

	// bi-directional many-to-one association to Activitytype
	@ManyToOne
	@JoinColumn(name = "documentid", nullable = false)
	private Document document;
	
	@Column(length = 1000)
	private String note;
	
	public Misidentification() {
	}
	
	public Taxon getTaxon() {
		return taxon;
	}

	public void setTaxon(Taxon taxon) {
		this.taxon = taxon;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}

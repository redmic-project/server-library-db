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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.db.common.model.UpdatableModel;
import es.redmic.db.maintenance.animal.model.Destiny;
import es.redmic.db.maintenance.animal.model.Ending;

/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name = "recovery")
@NamedQuery(name = "Recovery.findAll", query = "SELECT r FROM Recovery r")
public class Recovery extends UpdatableModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 1000)
	private String note;

	private Integer convalescence;

	// bi-directional many-to-one association to ending
	@ManyToOne
	@JoinColumn(name = "endingid")
	private Ending ending;

	// bi-directional many-to-one association to destiny
	@ManyToOne
	@JoinColumn(name = "destinyid")
	private Destiny destiny;

	// bi-directional many-to-one association to animal
	@ManyToOne
	@JoinColumn(name = "animalid")
	private Animal animal;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime releasedate;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime admissiondate;

	@Column(length = 150)
	private String releaseplace;

	public Recovery() {
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Ending getEnding() {
		return ending;
	}

	public void setEnding(Ending ending) {
		this.ending = ending;
	}

	public Destiny getDestiny() {
		return destiny;
	}

	public void setDestiny(Destiny destiny) {
		this.destiny = destiny;
	}

	public DateTime getReleaseDate() {
		return releasedate;
	}

	public void setReleaseDate(DateTime releasedate) {
		this.releasedate = releasedate;
	}

	public DateTime getAdmissionDate() {
		return admissiondate;
	}

	public void setAdmissionDate(DateTime admissionDate) {
		this.admissiondate = admissionDate;
	}

	public String getReleasePlace() {
		return releaseplace;
	}

	public void setReleasePlace(String releaseplace) {
		this.releaseplace = releaseplace;
	}

	public Integer getConvalescence() {
		return convalescence;
	}

	public void setConvalescence(Integer convalescence) {
		this.convalescence = convalescence;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}

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

import es.redmic.db.common.model.UpdatableModel;

/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name = "specimentag")
@NamedQuery(name = "Specimentag.findAll", query = "SELECT s FROM SpecimenTag s")
public class SpecimenTag extends UpdatableModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to animal
	@ManyToOne
	@JoinColumn(name = "animalid")
	private Animal animal;

	@Column(length = 150)
	private String code;

	@Column(length = 150)
	private String type;

	@Column(length = 150)
	private String provider;

	@Column(length = 150)
	private String placement;

	public SpecimenTag() {
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String tagNumber) {
		this.code = tagNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getPlacement() {
		return placement;
	}

	public void setPlacement(String placement) {
		this.placement = placement;
	}
}

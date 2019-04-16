package es.redmic.db.maintenance.parameter.model;

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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import es.redmic.databaselib.common.model.LongModel;

/**
 * The persistent class for the unit database table.
 * 
 */
@Entity
@NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u")
public class Unit extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String acronym;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 50, nullable = false)
	private String name_en;

	// bi-directional many-to-one association to Parametertype
	@ManyToOne
	@JoinColumn(name = "unittypeid")
	private UnitType unittype;

	// bi-directional many-to-one association to Device
	@OneToMany(mappedBy = "unit")
	private List<ParameterUnit> parameterunits;

	public Unit() {
	}

	public String getAcronym() {
		return this.acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_en() {
		return this.name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public UnitType getUnitType() {
		return unittype;
	}

	public void setUnitType(UnitType unittype) {
		this.unittype = unittype;
	}

	public List<ParameterUnit> getParameterUnits() {
		return parameterunits;
	}

	public void setParameterUnits(List<ParameterUnit> parameterunits) {
		this.parameterunits = parameterunits;
	}

	public ParameterUnit addParameterunit(ParameterUnit parameterunit) {
		getParameterUnits().add(parameterunit);
		parameterunit.setUnit(this);

		return parameterunit;
	}

	public ParameterUnit removeParameterunit(ParameterUnit parameterunit) {
		getParameterUnits().remove(parameterunit);
		parameterunit.setUnit(null);

		return parameterunit;
	}
}

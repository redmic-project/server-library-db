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

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;


/**
 * The persistent class for the parameterunit database table.
 * 
 */
@Entity
@Table(name="parameterunit")
@NamedQuery(name="ParameterUnit.findAll", query="SELECT p FROM ParameterUnit p")
public class ParameterUnit extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name = "parameterid", nullable = false)
	private Parameter parameter;
	
	// bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name = "unitid", nullable = false)
	private Unit unit;
	
	public ParameterUnit() {
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}

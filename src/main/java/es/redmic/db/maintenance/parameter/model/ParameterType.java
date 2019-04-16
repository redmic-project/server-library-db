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

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the parametertype database table.
 * 
 */
@Entity
@Table(name="parametertype")
@NamedQuery(name="ParameterType.findAll", query="SELECT p FROM ParameterType p")
public class ParameterType extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to Parameter
	@OneToMany(mappedBy="parametertype")
	private List<Parameter> parameters;

	public ParameterType() {
	}

	public List<Parameter> getParameters() {
		return this.parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public Parameter addParameter(Parameter parameter) {
		getParameters().add(parameter);
		parameter.setParameterType(this);

		return parameter;
	}

	public Parameter removeParameter(Parameter parameter) {
		getParameters().remove(parameter);
		parameter.setParameterType(null);

		return parameter;
	}

}

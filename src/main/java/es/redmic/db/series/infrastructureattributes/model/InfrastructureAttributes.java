package es.redmic.db.series.infrastructureattributes.model;

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
import javax.persistence.Table;

import es.redmic.db.geodata.infrastructure.model.Infrastructure;
import es.redmic.db.maintenance.qualifiers.model.Attributes;

@Entity
@Table(name="infrastructureattributes")
@NamedQuery(name="InfrastructureAttributes.findAll", query="SELECT i FROM InfrastructureAttributes i")
public class InfrastructureAttributes extends Attributes {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="infrastructurepointid", nullable = false)
	private Infrastructure infrastructure;
	
	public Infrastructure getInfrastructure() {
		return infrastructure;
	}

	public void setInfrastructure(Infrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}
}

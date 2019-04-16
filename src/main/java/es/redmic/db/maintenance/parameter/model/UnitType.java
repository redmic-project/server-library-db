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
 * The persistent class for the unittype database table.
 * 
 */
@Entity
@Table(name="unittype")
@NamedQuery(name="UnitType.findAll", query="SELECT u FROM UnitType u")
public class UnitType extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to Unit
	@OneToMany(mappedBy="unittype")
	private List<Unit> units;
	
	public UnitType() {
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	
	public Unit addUnit(Unit unit) {
		getUnits().add(unit);
		unit.setUnitType(this);

		return unit;
	}

	public Unit removeUnit(Unit unit) {
		getUnits().remove(unit);
		unit.setUnitType(null);

		return unit;
	}

}

package es.redmic.db.maintenance.areas.model;

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

import es.redmic.db.maintenance.common.model.ClassificationBase;

/**
 * The persistent class for the thematicunit database table.
 * 
 */
@Entity
@Table(name="thematictype")
@NamedQuery(name="ThematicType.findAll", query="SELECT c FROM ThematicType c")
public class ThematicType extends ClassificationBase {
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 7)
	private String colour;

	@ManyToOne
	@JoinColumn(name = "parentid")
	private ThematicType parent;

	public ThematicType() {
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public ThematicType getParent() {
		return parent;
	}

	public void setParent(ThematicType parent) {
		this.parent = parent;
	}
}

package es.redmic.db.maintenance.objects.model;

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

import es.redmic.db.maintenance.common.model.ClassificationBase;

@Entity
@Table(name="objecttype")
@NamedQuery(name="ObjectType.findAll", query="SELECT o FROM ObjectType o")
public class ObjectType extends ClassificationBase implements Serializable {
	
	private static final long serialVersionUID = 1534534234L;
	
	@ManyToOne
	@JoinColumn(name = "parentid")
	private ObjectType parent;

	
	public ObjectType getParent() {
		return this.parent;
	}

	public void setParent(ObjectType parent) {
		this.parent = parent;
	}
}

package es.redmic.db.series.objectcollecting.model;

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
import es.redmic.db.maintenance.objects.model.ObjectType;

/**
 * The persistent class for the timeseries database table.
 * 
 */
@Entity
@Table(name="objectcollectingclassification")
@NamedQuery(name="ObjectCollectingClassification.findAll", query="SELECT o FROM ObjectCollectingClassification o")
public class ObjectCollectingClassification extends LongModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="objectcollectingid", nullable = false)
	private ObjectCollecting objectCollecting;
	
	@ManyToOne
	@JoinColumn(name="objecttypeid", nullable = false)
	private ObjectType objectType;
	
	public ObjectCollecting getObjectCollecting() {
		return objectCollecting;
	}

	public void setObjectCollecting(ObjectCollecting objectCollecting) {
		this.objectCollecting = objectCollecting;
	}

	public ObjectType getObjectType() {
		return objectType;
	}

	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}
}

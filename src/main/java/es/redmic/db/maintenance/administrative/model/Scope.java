package es.redmic.db.maintenance.administrative.model;

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
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.model.ActivityBase;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the scope database table.
 * 
 */
@Entity
@Table(name = "scope")
@NamedQuery(name = "Scope.findAll", query = "SELECT s FROM Scope s")
public class Scope extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Activity
	@OneToMany(mappedBy = "scope")
	private Set<ActivityBase> activities;

	public Scope() {
	}

	public Set<ActivityBase> getActivities() {
		return this.activities;
	}

	public void setActivities(Set<ActivityBase> activities) {
		this.activities = activities;
	}

	public ActivityBase addActivity(ActivityBase activity) {
		getActivities().add(activity);
		activity.setScope(this);

		return activity;
	}

	public ActivityBase removeActivity(ActivityBase activity) {
		getActivities().remove(activity);
		activity.setScope(null);

		return activity;
	}
}

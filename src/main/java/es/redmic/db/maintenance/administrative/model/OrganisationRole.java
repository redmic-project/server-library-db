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

import es.redmic.db.administrative.model.ActivityOrganisationRole;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the organisationrole database table.
 * 
 */
@Entity
@Table(name = "organisationrole")
@NamedQuery(name = "Organisationrole.findAll", query = "SELECT o FROM OrganisationRole o")
public class OrganisationRole extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Activityorganisationrole
	@OneToMany(mappedBy = "role")
	private Set<ActivityOrganisationRole> activityorganisationroles;

	public OrganisationRole() {
	}

	public Set<ActivityOrganisationRole> getActivityorganisationroles() {
		return this.activityorganisationroles;
	}

	public void setActivityorganisationroles(Set<ActivityOrganisationRole> activityorganisationroles) {
		this.activityorganisationroles = activityorganisationroles;
	}

	public ActivityOrganisationRole addActivityorganisationrole(ActivityOrganisationRole activityorganisationrole) {
		getActivityorganisationroles().add(activityorganisationrole);
		activityorganisationrole.setRole(this);

		return activityorganisationrole;
	}

	public ActivityOrganisationRole removeActivityorganisationrole(ActivityOrganisationRole activityorganisationrole) {
		getActivityorganisationroles().remove(activityorganisationrole);
		activityorganisationrole.setRole(null);

		return activityorganisationrole;
	}
}

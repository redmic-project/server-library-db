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

import es.redmic.db.administrative.model.ActivityContactRole;
import es.redmic.db.administrative.model.PlatformContactRole;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the contactrole database table.
 * 
 */
@Entity
@Table(name = "contactrole")
@NamedQuery(name = "Contactrole.findAll", query = "SELECT c FROM ContactRole c")
public class ContactRole extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Activitycontactrole
	@OneToMany(mappedBy = "role")
	private Set<ActivityContactRole> activitycontactroles;

	// bi-directional many-to-one association to Platformcontactrole
	@OneToMany(mappedBy = "role")
	private Set<PlatformContactRole> platformcontactroles;

	public ContactRole() {
	}

	public Set<ActivityContactRole> getActivitycontactroles() {
		return this.activitycontactroles;
	}

	public void setActivitycontactroles(Set<ActivityContactRole> activitycontactroles) {
		this.activitycontactroles = activitycontactroles;
	}

	public ActivityContactRole addActivitycontactrole(ActivityContactRole activitycontactrole) {
		getActivitycontactroles().add(activitycontactrole);
		activitycontactrole.setRole(this);

		return activitycontactrole;
	}

	public ActivityContactRole removeActivitycontactrole(ActivityContactRole activitycontactrole) {
		getActivitycontactroles().remove(activitycontactrole);
		activitycontactrole.setRole(null);

		return activitycontactrole;
	}

	public Set<PlatformContactRole> getPlatformcontactroles() {
		return this.platformcontactroles;
	}

	public void setPlatformcontactroles(Set<PlatformContactRole> platformcontactroles) {
		this.platformcontactroles = platformcontactroles;
	}

	public PlatformContactRole addPlatformcontactrole(PlatformContactRole platformcontactrole) {
		getPlatformcontactroles().add(platformcontactrole);
		platformcontactrole.setRole(this);

		return platformcontactrole;
	}

	public PlatformContactRole removePlatformcontactrole(PlatformContactRole platformcontactrole) {
		getPlatformcontactroles().remove(platformcontactrole);
		platformcontactrole.setRole(null);

		return platformcontactrole;
	}
}

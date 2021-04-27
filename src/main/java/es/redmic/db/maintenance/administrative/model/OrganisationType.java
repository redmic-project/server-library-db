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

import es.redmic.db.administrative.model.Organisation;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the organisationtype database table.
 * 
 */
@Entity
@Table(name = "organisationtype")
@NamedQuery(name = "Organisationtype.findAll", query = "SELECT o FROM OrganisationType o")
public class OrganisationType extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Organisation
	@OneToMany(mappedBy = "organisationtype")
	private Set<Organisation> organisations;

	public OrganisationType() {
	}

	public Set<Organisation> getOrganisations() {
		return this.organisations;
	}

	public void setOrganisations(Set<Organisation> organisations) {
		this.organisations = organisations;
	}

	public Organisation addOrganisation(Organisation organisation) {
		getOrganisations().add(organisation);
		organisation.setOrganisationType(this);

		return organisation;
	}

	public Organisation removeOrganisation(Organisation organisation) {
		getOrganisations().remove(organisation);
		organisation.setOrganisationType(null);

		return organisation;
	}

}

package es.redmic.db.maintenance.administrative.model;

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
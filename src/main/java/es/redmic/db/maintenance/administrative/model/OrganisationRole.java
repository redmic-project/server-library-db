package es.redmic.db.maintenance.administrative.model;

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
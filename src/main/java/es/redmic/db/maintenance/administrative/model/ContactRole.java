package es.redmic.db.maintenance.administrative.model;

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
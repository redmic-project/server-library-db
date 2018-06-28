package es.redmic.db.maintenance.administrative.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the activityfield database table.
 * 
 */
@Entity
@Table(name="activityfield")
@NamedQuery(name = "Activityfield.findAll", query = "SELECT a FROM ActivityField a")
public class ActivityField extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to Activitytype
	@OneToMany(mappedBy="activityField")
	private Set<ActivityType> activityTypes;

	public ActivityField() {
	}

	public Set<ActivityType> getActivitytypes() {
		return this.activityTypes;
	}

	public void setActivitytypes(Set<ActivityType> activityTypes) {
		this.activityTypes = activityTypes;
	}

	public ActivityType addActivitytype(ActivityType activitytype) {
		getActivitytypes().add(activitytype);
		activitytype.setActivityField(this);

		return activitytype;
	}

	public ActivityType removeActivitytype(ActivityType activitytype) {
		getActivitytypes().remove(activitytype);
		activitytype.setActivityField(null);

		return activitytype;
	}

}
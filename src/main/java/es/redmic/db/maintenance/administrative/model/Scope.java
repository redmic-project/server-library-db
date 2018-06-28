package es.redmic.db.maintenance.administrative.model;

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
package es.redmic.db.maintenance.administrative.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.administrative.model.Activity;

/**
 * The persistent class for the activitytype database table.
 * 
 */
@Entity
@Table(name = "activitytype")
@NamedQuery(name = "ActivityType.findAll", query = "SELECT a FROM ActivityType a")
public class ActivityType extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String description;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 50)
	private String name_en;

	// bi-directional many-to-one association to Activity
	@OneToMany(mappedBy = "activityType")
	private Set<Activity> activities;

	// bi-directional many-to-one association to Activityfield
	@ManyToOne
	@JoinColumn(name = "activityfieldid", nullable = false)
	private ActivityField activityField;

	public ActivityType() {
		super();
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_en() {
		return this.name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public Set<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		activity.setActivityType(this);

		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		activity.setActivityType(null);

		return activity;
	}

	public ActivityField getActivityField() {
		return this.activityField;
	}

	public void setActivityField(ActivityField activityField) {
		this.activityField = activityField;
	}

}
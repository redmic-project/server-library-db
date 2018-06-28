package es.redmic.db.administrative.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.redmic.db.maintenance.administrative.model.ActivityType;

/**
 * The persistent class for the activity database table.
 * 
 */
@Entity
@Cacheable
@DiscriminatorValue(value = "3")
public class Activity extends ActivityBase {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Activitytype
	@ManyToOne
	@JoinColumn(name = "activitytypeid", nullable = false)
	private ActivityType activityType;

	// bi-directional many-to-one association to Embargo
	@ManyToOne
	@JoinColumn(name = "embargoid")
	private Embargo embargo;
	
	@Column(name = "activitycategory", length = 2)
	private String activityCategory;

	public Activity() {
	}

	public ActivityType getActivityType() {
		return this.activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public Embargo getEmbargo() {
		return this.embargo;
	}

	public void setEmbargo(Embargo embargo) {
		this.embargo = embargo;
	}

	public String getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(String activityCategory) {
		this.activityCategory = activityCategory;
	}
}
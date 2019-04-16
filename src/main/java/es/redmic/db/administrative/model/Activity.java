package es.redmic.db.administrative.model;

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

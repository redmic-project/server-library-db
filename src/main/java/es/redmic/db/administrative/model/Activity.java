package es.redmic.db.administrative.model;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 - 2021 REDMIC Project / Server
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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import es.redmic.db.maintenance.administrative.model.ActivityType;
import es.redmic.db.maintenance.administrative.model.ThemeInspire;

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

	// bi-directional many-to-one association to ThemeInspire
	@ManyToOne
	@JoinColumn(name = "themeinspireid")
	private ThemeInspire themeInspire;

	@Column(name = "activitycategory", length = 2)
	private String activityCategory;

	@Column(length = 5000)
	private String licence;

	@Column(length = 5000)
	private String normative;

	@Column(name = "spatialextension")
	private String spatialExtension;

	@Column
	private Boolean starred;

	// bi-directional many-to-one association to ActivityResource
	@OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ActivityResource> resources = new HashSet<>();

	public Activity() {
		// Constructor por defecto para que accedan los mappers
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

	public ThemeInspire getThemeInspire() {
		return this.themeInspire;
	}

	public void setThemeInspire(ThemeInspire themeInspire) {
		this.themeInspire = themeInspire;
	}

	public String getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(String activityCategory) {
		this.activityCategory = activityCategory;
	}

	public String getLicence() {
		return this.licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getNormative() {
		return this.normative;
	}

	public void setNormative(String normative) {
		this.normative = normative;
	}

	public String getSpatialExtension() {
		return this.spatialExtension;
	}

	public void setSpatialExtension(String spatialExtension) {
		this.spatialExtension = spatialExtension;
	}

	public Set<ActivityResource> getResources() {
		return resources;
	}

	public Boolean getStarred() {
		return this.starred;
	}

	public void setStarred(Boolean starred) {
		this.starred = starred;
	}

	public void setResources(Set<ActivityResource> activityResources) {

		this.resources.clear();

		if (activityResources == null)
			return;

		for (ActivityResource resource: activityResources)
			addResource(resource);
	}

	public ActivityResource addResource(ActivityResource resource) {

		resource.setActivity(this);
		getResources().add(resource);
		return resource;
	}
}

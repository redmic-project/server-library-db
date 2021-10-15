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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import es.redmic.db.administrative.model.Activity;
import es.redmic.db.administrative.model.ActivityResource;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the activitytype database table.
 *
 */
@Entity
@Table(name = "resourcetype")
@NamedQuery(name = "ResourceType.findAll", query = "SELECT a FROM ResourceType a")
public class ResourceType extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String description;

	// bi-directional many-to-one association to Activityresources
	@OneToMany(mappedBy = "resourcetype")
	private Set<ActivityResource> activityresources;

	public ResourceType() {
		super();
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ActivityResource> getActivityresources() {
		return this.activityresources;
	}

	public void setActivityresources(Set<ActivityResource> activityresources) {
		this.activityresources = activityresources;
	}

	public ActivityResource addActivityresources(ActivityResource activityresources) {
		getActivityresources().add(activityresources);
		activityresources.setResourceType(this);

		return activityresources;
	}

	public ActivityResource removeActivityresources(ActivityResource activityresources) {
		getActivityresources().remove(activityresources);
		activityresources.setResourceType(null);

		return activityresources;
	}
}

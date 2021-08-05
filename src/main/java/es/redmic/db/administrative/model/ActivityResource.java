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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.maintenance.administrative.model.ResourceType;

/**
 * The persistent class for the activityresource database table.
 *
 */
@Entity
@Table(name = "activityresource")
@NamedQuery(name = "ActivityResource.findAll", query = "SELECT a FROM ActivityResource a")
public class ActivityResource extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "activityid", nullable = false)
	private ActivityBase activity;

	// bi-directional many-to-one association to Rank
	@ManyToOne
	@JoinColumn(name = "resourcetypeid", insertable = false, updatable = false, nullable=false)
	private ResourceType resourceType;

	@Column(name = "urlresource", length = 500)
	private String urlResource;

	public ActivityResource() {
		// Constructor por defecto para que accedan los mappers
	}

	public ActivityBase getActivity() {
		return this.activity;
	}

	public void setActivity(ActivityBase activityBase) {
		this.activity = activityBase;
	}

	public ResourceType getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrlResource() {
		return this.urlResource;
	}

	public void setUrlResource(String urlResource) {
		this.urlResource = urlResource;
	}
}

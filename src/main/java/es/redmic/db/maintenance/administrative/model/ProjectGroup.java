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

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.model.Project;
import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the projectgroup database table.
 * 
 */
@Entity
@Table(name="projectgroup")
@NamedQuery(name = "Projectgroup.findAll", query = "SELECT p FROM ProjectGroup p")
public class ProjectGroup extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="projectgroup")
	private Set<Project> projects;

	public ProjectGroup() {
	}

	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setProjectGroup(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setProjectGroup(null);

		return project;
	}

}

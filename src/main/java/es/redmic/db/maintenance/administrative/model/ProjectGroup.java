package es.redmic.db.maintenance.administrative.model;

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
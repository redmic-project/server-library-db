package es.redmic.db.administrative.model;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.redmic.db.maintenance.administrative.model.ProjectGroup;

/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Cacheable
@DiscriminatorValue(value = "2")
public class Project extends ActivityBase {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Projectgroup
	@ManyToOne
	@JoinColumn(name = "projectgroupid")
	private ProjectGroup projectgroup;

	public Project() {
	}

	public ProjectGroup getProjectGroup() {
		return this.projectgroup;
	}

	public void setProjectGroup(ProjectGroup projectgroup) {
		this.projectgroup = projectgroup;
	}
}
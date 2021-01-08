package es.redmic.db.administrative.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;

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

	@Column(nullable = false, length = 100)
	private String name;

	@Column(length = 1500)
	private String description;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlResource() {
		return this.urlResource;
	}

	public void setUrlResource(String urlResource) {
		this.urlResource = urlResource;
	}
}

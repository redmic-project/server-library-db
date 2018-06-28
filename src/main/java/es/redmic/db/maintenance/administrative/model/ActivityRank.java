package es.redmic.db.maintenance.administrative.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;

/**
 * The persistent class for the activityrank database table.
 * 
 */
@Entity
@Table(name = "activityrank")
@NamedQuery(name = "ActivityRank.findAll", query = "SELECT a FROM ActivityRank a")
public class ActivityRank extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	@Column(name = "name_en")
	private String nameEn;

	public ActivityRank() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

}
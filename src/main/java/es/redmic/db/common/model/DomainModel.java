package es.redmic.db.common.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import es.redmic.databaselib.common.model.LongModel;

@MappedSuperclass
public abstract class DomainModel extends LongModel {

	@Column(nullable = false, length = 50)
	private String name;
	
	private String name_en;

	public DomainModel() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

}

package es.redmic.db.maintenance.quality.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import es.redmic.databaselib.common.model.CharacterModel;

@MappedSuperclass
public abstract class FlagBase extends CharacterModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1859354405689556595L;

	private String name;

	@Column(name = "name_en")
	private String name_en;


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

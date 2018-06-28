package es.redmic.db.atlas.layer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the themeinspire database table.
 * 
 */
@Entity
@Table(name="themeinspire")
@NamedQuery(name = "ThemeInspire.findAll", query = "SELECT a FROM ThemeInspire a")
public class ThemeInspire extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String code;
	
	public ThemeInspire() {
		
	}
	
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
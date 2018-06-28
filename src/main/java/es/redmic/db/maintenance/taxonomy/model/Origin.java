package es.redmic.db.maintenance.taxonomy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.taxonomy.model.Peculiarity;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the origin database table.
 * 
 */
@Entity
@Table(name = "origin")
@NamedQuery(name = "Origin.findAll", query = "SELECT o FROM Origin o")
public class Origin extends DomainModel {

	// bi-directional many-to-one association to Protection
	@OneToMany(mappedBy = "origin")
	private List<Peculiarity> protections;

	public Origin() {
		super();
	}

	public List<Peculiarity> getProtections() {
		return this.protections;
	}

	public void setProtections(List<Peculiarity> protections) {
		this.protections = protections;
	}

	public Peculiarity addProtection(Peculiarity protection) {
		getProtections().add(protection);
		protection.setOrigin(this);

		return protection;
	}

	public Peculiarity removeProtection(Peculiarity protection) {
		getProtections().remove(protection);
		protection.setOrigin(null);

		return protection;
	}

}
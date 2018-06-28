package es.redmic.db.maintenance.taxonomy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.taxonomy.model.Peculiarity;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the endemicity database table.
 * 
 */
@Entity
@Table(name = "endemicity")
@NamedQuery(name = "Endemicity.findAll", query = "SELECT e FROM Endemicity e")
public class Endemicity extends DomainModel {

	// bi-directional many-to-one association to Protection
	@OneToMany(mappedBy = "endemicity")
	private List<Peculiarity> protections;

	public Endemicity() {
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
		protection.setEndemicity(this);

		return protection;
	}

	public Peculiarity removeProtection(Peculiarity protection) {
		getProtections().remove(protection);
		protection.setEndemicity(null);

		return protection;
	}



}
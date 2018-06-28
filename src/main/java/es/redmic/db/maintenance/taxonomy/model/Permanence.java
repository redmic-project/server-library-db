package es.redmic.db.maintenance.taxonomy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.taxonomy.model.Peculiarity;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the permanence database table.
 * 
 */
@Entity
@Table(name = "permanence")
@NamedQuery(name = "Permanence.findAll", query = "SELECT p FROM Permanence p")
public class Permanence extends DomainModel {

	// bi-directional many-to-one association to Protection
	@OneToMany(mappedBy = "permanence")
	private List<Peculiarity> protections;

	public Permanence() {
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
		protection.setPermanence(this);

		return protection;
	}

	public Peculiarity removeProtection(Peculiarity protection) {
		getProtections().remove(protection);
		protection.setPermanence(null);

		return protection;
	}
}
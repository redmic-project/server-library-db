package es.redmic.db.maintenance.taxonomy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.taxonomy.model.Peculiarity;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the interest database table.
 * 
 */
@Entity
@Table(name = "interest")
@NamedQuery(name = "Interest.findAll", query = "SELECT i FROM Interest i")
public class Interest extends DomainModel {

	// bi-directional many-to-one association to Protection
	@OneToMany(mappedBy = "interest")
	private List<Peculiarity> protections;

	public Interest() {
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
		protection.setInterest(this);

		return protection;
	}

	public Peculiarity removeProtection(Peculiarity protection) {
		getProtections().remove(protection);
		protection.setInterest(null);

		return protection;
	}

}
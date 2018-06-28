package es.redmic.db.maintenance.taxonomy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.taxonomy.model.Peculiarity;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the eudirective database table.
 * 
 */
@Entity
@Table(name = "euprotection")
@NamedQuery(name = "EUProtection.findAll", query = "SELECT e FROM EUProtection e")
public class EUProtection extends DomainModel {

	// bi-directional many-to-one association to Protection
	@OneToMany(mappedBy = "euprotection")
	private List<Peculiarity> protections;

	public EUProtection() {
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
		protection.setEuProtection(this);

		return protection;
	}

	public Peculiarity removeProtection(Peculiarity protection) {
		getProtections().remove(protection);
		protection.setEuProtection(null);

		return protection;
	}
}
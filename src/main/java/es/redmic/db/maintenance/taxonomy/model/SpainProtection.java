package es.redmic.db.maintenance.taxonomy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.taxonomy.model.Peculiarity;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the spaincatalogue database table.
 * 
 */
@Entity
@Table(name = "spainprotection")
@NamedQuery(name = "SpainProtection.findAll", query = "SELECT s FROM SpainProtection s")
public class SpainProtection extends DomainModel {

	// bi-directional many-to-one association to Protection
	@OneToMany(mappedBy = "spainprotection")
	private List<Peculiarity> protections;

	public SpainProtection() {
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
		protection.setSpainProtection(this);

		return protection;
	}

	public Peculiarity removeProtection(Peculiarity protection) {
		getProtections().remove(protection);
		protection.setSpainProtection(null);

		return protection;
	}

}
package es.redmic.db.maintenance.taxonomy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.taxonomy.model.Peculiarity;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the canarycatalogue database table.
 * 
 */
@Entity
@Table(name = "trophicregime")
@NamedQuery(name = "TrophicRegime.findAll", query = "SELECT c FROM TrophicRegime c")
public class TrophicRegime extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Protection
	@OneToMany(mappedBy = "trophicregime")
	private List<Peculiarity> protections;

	public TrophicRegime() {
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
		protection.setTrophicRegime(this);
		return protection;
	}

	public Peculiarity removeProtection(Peculiarity protection) {
		getProtections().remove(protection);
		protection.setTrophicRegime(null);

		return protection;
	}

}
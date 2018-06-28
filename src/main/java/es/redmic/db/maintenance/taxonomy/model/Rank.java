package es.redmic.db.maintenance.taxonomy.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.taxonomy.model.Taxon;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the rank database table.
 * 
 */
@Entity
@Table(name = "rankk")
@NamedQuery(name = "Rank.findAll", query = "SELECT r FROM Rank r")
public class Rank extends DomainModel {

	@OneToMany(mappedBy = "rank")
	private Set<Taxon> taxons;

	public Rank() {
	}

	public Set<Taxon> getTaxons() {
		return this.taxons;
	}

	public void setTaxons(Set<Taxon> taxons) {
		this.taxons = taxons;
	}

	public Taxon addTaxon(Taxon taxon) {
		getTaxons().add(taxon);
		taxon.setRank(this);

		return taxon;
	}

	public Taxon removeTaxon(Taxon taxon) {
		getTaxons().remove(taxon);
		taxon.setRank(null);

		return taxon;
	}

}
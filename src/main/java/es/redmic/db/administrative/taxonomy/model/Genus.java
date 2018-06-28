package es.redmic.db.administrative.taxonomy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "9")
public class Genus extends Taxon {

	public Genus() {
	}
}

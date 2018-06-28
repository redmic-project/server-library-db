package es.redmic.db.administrative.taxonomy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "5")
public class Subfilum extends Taxon {

	public Subfilum() {
	}
}

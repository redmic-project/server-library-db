package es.redmic.db.administrative.taxonomy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "7")
public class Orderr extends Taxon {

	public Orderr() {
	}

}

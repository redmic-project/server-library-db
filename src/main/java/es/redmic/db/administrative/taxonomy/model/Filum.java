package es.redmic.db.administrative.taxonomy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "3")
public class Filum extends Taxon {

	public Filum() {
	}

}

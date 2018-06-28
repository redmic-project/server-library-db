package es.redmic.db.administrative.taxonomy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "8")
public class Family extends Taxon {

	public Family() {
	}

}

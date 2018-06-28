package es.redmic.db.administrative.taxonomy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "10")
public class Species extends AbstractSpecies {

	public Species() {
	}
}

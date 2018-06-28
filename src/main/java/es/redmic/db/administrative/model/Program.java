package es.redmic.db.administrative.model;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The persistent class for the program database table.
 * 
 */
@Entity
@Cacheable
@DiscriminatorValue(value = "1")
public class Program extends ActivityBase {
	private static final long serialVersionUID = 1L;

	public Program() {
	}
}
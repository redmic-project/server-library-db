package es.redmic.db.geodata.tracking.animal.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.administrative.taxonomy.model.Animal;
import es.redmic.db.geodata.tracking.common.model.BaseTracking;

/**
 * The persistent class for the citation database view.
 * 
 */
@Entity
@Table(name = "animaltracking")
@NamedQuery(name = "AnimalTracking.findAll", query = "SELECT c FROM AnimalTracking c")
public class AnimalTracking extends BaseTracking {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4817780981392203587L;

	
	// bi-directional many-to-one association to Animal
	@ManyToOne
	@JoinColumn(name = "animalid")
	private Animal animal;
	
	private String note;
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
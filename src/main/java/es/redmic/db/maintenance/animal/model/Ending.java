package es.redmic.db.maintenance.animal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the ending database table.
 * 
 */
@Entity
@Table(name="ending")
@NamedQuery(name="Ending.findAll", query="SELECT e FROM Ending e")
public class Ending extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public Ending() {
	}

}
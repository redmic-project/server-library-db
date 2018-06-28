package es.redmic.db.maintenance.animal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the destiny database table.
 * 
 */
@Entity
@Table(name="destiny")
@NamedQuery(name="Destiny.findAll", query="SELECT d FROM Destiny d")
public class Destiny extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public Destiny() {
	}

}
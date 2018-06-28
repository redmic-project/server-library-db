package es.redmic.db.maintenance.common.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the accessibility database table.
 * 
 */
@Entity
@Table(name = "accessibility")
@NamedQuery(name = "Accessibility.findAll", query = "SELECT a FROM Accessibility a")
public class Accessibility extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public Accessibility() {
		super();
	}
}
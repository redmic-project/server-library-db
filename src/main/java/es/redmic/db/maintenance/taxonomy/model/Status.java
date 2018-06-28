package es.redmic.db.maintenance.taxonomy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name = "status")
@NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
public class Status extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public Status() {
		super();
	}
}
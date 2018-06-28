package es.redmic.db.maintenance.toponym.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the citation database view.
 * 
 */
@Entity
@Table(name = "toponymtype")
@NamedQuery(name = "ToponymType.findAll", query = "SELECT c FROM ToponymType c")
public class ToponymType extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public ToponymType() {
		super();
	}
}
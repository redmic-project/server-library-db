package es.redmic.db.maintenance.areas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the areatype database table.
 * 
 */
@Entity
@Table(name = "areatype")
@NamedQuery(name = "AreaType.findAll", query = "SELECT a FROM AreaType a")
public class AreaType extends DomainModel implements Serializable {

	private static final long serialVersionUID = 1L;

	public AreaType() {
	}
}
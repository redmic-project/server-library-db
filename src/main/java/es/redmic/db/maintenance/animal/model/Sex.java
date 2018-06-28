package es.redmic.db.maintenance.animal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the sex database table.
 * 
 */
@Entity
@Table(name="sex")
@NamedQuery(name="Sex.findAll", query="SELECT s FROM Sex s")
public class Sex extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public Sex() {
	}

}
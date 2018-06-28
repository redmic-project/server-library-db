package es.redmic.db.maintenance.strech.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the seacondition database table.
 * 
 */
@Entity
@Table(name="seacondition")
@NamedQuery(name="SeaCondition.findAll", query="SELECT s FROM SeaCondition s")
public class SeaCondition extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public SeaCondition() {
	}


}
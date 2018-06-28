package es.redmic.db.maintenance.strech.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the censingstatus database table.
 * 
 */
@Entity
@Table(name="censingstatus")
@NamedQuery(name="CensingStatus.findAll", query="SELECT c FROM CensingStatus c")
public class CensingStatus extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;


	public CensingStatus() {
	}

}
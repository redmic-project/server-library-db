package es.redmic.db.maintenance.quality.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the qflag database table.
 * 
 */
@Entity
@Table(name = "qflag")
@NamedQuery(name = "QFlag.findAll", query = "SELECT q FROM QFlag q")
public class QFlag extends FlagBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2704870371087499910L;

}
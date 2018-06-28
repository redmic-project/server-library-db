package es.redmic.db.maintenance.quality.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the vflag database table.
 * 
 */
@Entity
@Table(name = "vflag")
@NamedQuery(name = "VFlag.findAll", query = "SELECT v FROM VFlag v")
public class VFlag extends FlagBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3382235282933199004L;

}
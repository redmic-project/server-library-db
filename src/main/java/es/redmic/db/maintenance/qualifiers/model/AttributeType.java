package es.redmic.db.maintenance.qualifiers.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.maintenance.common.model.ClassificationBase;

/**
 * The persistent class for the attributetype database table.
 * 
 */
@Entity
@Table(name="attributetype")
@NamedQuery(name = "AttributeType.findAll", query = "SELECT a FROM AttributeType a")
public class AttributeType extends ClassificationBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "parentid")
	private AttributeType parent;

	public AttributeType() {
	}
	
	public AttributeType getParent() {
		return parent;
	}

	public void setParent(AttributeType parent) {
		this.parent = parent;
	}
}
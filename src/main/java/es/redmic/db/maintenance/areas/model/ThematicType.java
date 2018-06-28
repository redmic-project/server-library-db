package es.redmic.db.maintenance.areas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.maintenance.common.model.ClassificationBase;

/**
 * The persistent class for the thematicunit database table.
 * 
 */
@Entity
@Table(name="thematictype")
@NamedQuery(name="ThematicType.findAll", query="SELECT c FROM ThematicType c")
public class ThematicType extends ClassificationBase {
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 7)
	private String colour;

	@ManyToOne
	@JoinColumn(name = "parentid")
	private ThematicType parent;

	public ThematicType() {
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public ThematicType getParent() {
		return parent;
	}

	public void setParent(ThematicType parent) {
		this.parent = parent;
	}
}
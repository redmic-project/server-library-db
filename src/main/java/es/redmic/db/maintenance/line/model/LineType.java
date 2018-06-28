package es.redmic.db.maintenance.line.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.maintenance.common.model.ClassificationBase;


/**
 * The persistent class for the linetype database table.
 * 
 */
@Entity
@Table(name="linetype")
@NamedQuery(name="LineType.findAll", query="SELECT l FROM LineType l")
public class LineType extends ClassificationBase {
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 1500)
	private String remark;
	
	@ManyToOne
	@JoinColumn(name = "parentid")
	private LineType parent;
	
	public LineType() {
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LineType getParent() {
		return parent;
	}

	public void setParent(LineType parent) {
		this.parent = parent;
	}
}
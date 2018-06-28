package es.redmic.db.maintenance.point.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.redmic.db.maintenance.common.model.ClassificationBase;


/**
 * The persistent class for the infrastructurepointtype database table.
 * 
 */
@Entity
@Table(name = "infrastructurepointtype")
public class InfrastructureType extends ClassificationBase {
	private static final long serialVersionUID = 1L;

	@Column(length = 1500)
	private String remark;
	
	@ManyToOne
	@JoinColumn(name = "parentid")
	private InfrastructureType parent;

	public InfrastructureType() {
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public InfrastructureType getParent() {
		return parent;
	}

	public void setParent(InfrastructureType parent) {
		this.parent = parent;
	}
}
package es.redmic.db.geodata.tracking.platform.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.administrative.model.Platform;
import es.redmic.db.geodata.tracking.common.model.BaseTracking;

/**
 * The persistent class for the platformtracking.
 * 
 */
@Entity
@Table(name = "platformtracking")
@NamedQuery(name = "PlatformTracking.findAll", query = "SELECT c FROM PlatformTracking c")
public class PlatformTracking extends BaseTracking {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1278743955707145193L;
		
	@ManyToOne
	@JoinColumn(name = "platformid")
	private Platform platform;
	
	private String remark;

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
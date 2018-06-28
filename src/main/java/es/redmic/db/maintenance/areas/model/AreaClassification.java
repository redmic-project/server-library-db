package es.redmic.db.maintenance.areas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.geodata.area.model.Area;

/**
 * The persistent class for the classificationsector database table.
 * 
 */
@Entity
@Table(name = "areaclassification")
@NamedQuery(name = "AreaClassification.findAll", query = "SELECT c FROM AreaClassification c")
public class AreaClassification extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 1500)
	private String remark;

	@ManyToOne
	@JoinColumn(name = "areaid", nullable = false)
	private Area area;

	@ManyToOne
	@JoinColumn(name = "thematictypeid", nullable = false)
	private ThematicType thematicType;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime startdate;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime enddate;

	public AreaClassification() {
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public ThematicType getThematicType() {
		return thematicType;
	}

	public void setThematicType(ThematicType thematicType) {
		this.thematicType = thematicType;
	}

	public DateTime getStartDate() {
		return startdate;
	}

	public void setStartDate(DateTime startdate) {
		this.startdate = startdate;
	}

	public DateTime getEndDate() {
		return enddate;
	}

	public void setEndDate(DateTime enddate) {
		this.enddate = enddate;
	}
}
package es.redmic.db.maintenance.samples.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.geodata.area.model.Area;
import es.redmic.db.maintenance.device.model.Device;
import es.redmic.db.maintenance.parameter.model.Unit;


/**
 * The persistent class for the sample database table.
 * 
 */
@Entity
@NamedQuery(name="Sample.findAll", query="SELECT s FROM Sample s")
public class Sample extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 1500)
	private String description;

	@ManyToOne
	@JoinColumn(name="fixedareaid")
	private Area fixedarea;

	@Column(length = 250)
	private String image;

	@Column(length = 1500)
	private String note;

	private BigDecimal size;

	//bi-directional many-to-one association to Sampletype
	@ManyToOne
	@JoinColumn(name="sampletypeid", nullable = false)
	private SampleType sampletype;


	// bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name = "unitid", nullable = false)
	private Unit unit;


	//bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name="deviceid", nullable = false)
	private Device device;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime startdate;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime enddate;
	
	@Column(nullable=false)
	private Boolean hasduration;

	public Sample() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public BigDecimal getSize() {
		return size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public SampleType getSampletype() {
		return this.sampletype;
	}

	public void setSampletype(SampleType sampletype) {
		this.sampletype = sampletype;
	}


	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	
	public DateTime getStartDate() {
		return this.startdate;
	}

	public void setStartDate(DateTime startdate) {
		this.startdate = startdate;
	}
	
	public DateTime getEndDate() {
		return this.enddate;
	}

	public void setEndDate(DateTime enddate) {
		this.enddate = enddate;
	}

	public Boolean getHasDuration() {
		return hasduration;
	}

	public void setHasDuration(Boolean hasduration) {
		this.hasduration = hasduration;
	}

	public Area getFixedArea() {
		return fixedarea;
	}

	public void setFixedArea(Area fixedarea) {
		this.fixedarea = fixedarea;
	}
}
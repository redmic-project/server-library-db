package es.redmic.db.series.timeseries.model;

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

import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.db.series.common.model.SeriesBase;

/**
 * The persistent class for the timeseries database table.
 * 
 */
@Entity
@Table(name = "timeseries")
@NamedQuery(name = "TimeSeries.findAll", query = "SELECT t FROM TimeSeries t")
public class TimeSeries extends SeriesBase implements Serializable {
	private static final long serialVersionUID = 1L;

	private double z;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	@Column(nullable = false)
	private DateTime date;

	@Column(length = 1500)
	private String remark;

	@Column(nullable = false)
	private double value;

	// bi-directional many-to-one association to Measurement
	@ManyToOne
	@JoinColumn(name = "measurementid", nullable = false)
	private FixedMeasurement fixedMeasurement;

	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public DateTime getDate() {
		return this.date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public FixedMeasurement getFixedMeasurement() {
		return fixedMeasurement;
	}

	public void setFixedMeasurement(FixedMeasurement fixedMeasurement) {
		this.fixedMeasurement = fixedMeasurement;
	}
}
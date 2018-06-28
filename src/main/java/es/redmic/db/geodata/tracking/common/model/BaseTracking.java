package es.redmic.db.geodata.tracking.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.vividsolutions.jts.geom.Point;

import es.redmic.db.geodata.common.model.GeoDataModel;
import es.redmic.db.maintenance.device.model.Device;
import es.redmic.db.maintenance.quality.model.QFlag;
import es.redmic.db.maintenance.quality.model.VFlag;

@MappedSuperclass
public abstract class BaseTracking extends GeoDataModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1736606490310199870L;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	@Column(nullable = false)
	private DateTime date;

	private String code;

	private Double radius;
	
	@Column(name = "shape", nullable=false)
	Point geometry;

	private Double z;
	
	@Column(name = "argosid")
	private Integer argosId;
	
	@Type(type="es.redmic.db.common.type.EnumType", 
		parameters = { 
			@Parameter(name  = "enumClassName", value = "es.redmic.db.geodata.tracking.common.model.LocationClass") 
		})
	@Column(name = "locationclass")
	private LocationClass locationClass = null;
	
	@Column(name = "passduration")
	private Integer passDuration;
	
	@Column(name = "cumulativetime")
	private Double cumulativeTime;
	
	@Column(name = "cumulativekm")
	private Double cumulativeKm;
	
	private Double hours;
	
	@Column(name = "lastdistancekm")
	private Double lastDistanceKm;
	
	@Column(name = "speedkph")
	private Double speedKph;
	
	// bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name = "qflag")
	private QFlag qFlag;
	
	// bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name = "vflag")
	private VFlag vFlag;

	// bi-directional many-to-one association to SpeciesEquivalence
	@ManyToOne
	@JoinColumn(name = "deviceid")
	private Device device;

	public DateTime getDate() {
		return this.date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getRadius() {
		return this.radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Point getGeometry() {
		return geometry;
	}

	public void setGeometry(Point geometry) {
		this.geometry = geometry;
		this.geometry.setSRID(4326);
	}

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}
	
	public Integer getArgosId() {
		return argosId;
	}

	public void setArgosId(Integer argosId) {
		this.argosId = argosId;
	}

	public LocationClass getLocationClass() {
		return locationClass;
	}

	public void setLocationClass(LocationClass locationClass) {
		this.locationClass = locationClass;
	}

	public Integer getPassDuration() {
		return passDuration;
	}

	public void setPassDuration(Integer passDuration) {
		this.passDuration = passDuration;
	}

	public Double getCumulativeTime() {
		return cumulativeTime;
	}

	public void setCumulativeTime(Double cumulativeTime) {
		this.cumulativeTime = cumulativeTime;
	}

	public Double getCumulativeKm() {
		return cumulativeKm;
	}

	public void setCumulativeKm(Double cumulativeKm) {
		this.cumulativeKm = cumulativeKm;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public Double getLastDistanceKm() {
		return lastDistanceKm;
	}

	public void setLastDistanceKm(Double lastDistanceKm) {
		this.lastDistanceKm = lastDistanceKm;
	}

	public Double getSpeedKph() {
		return speedKph;
	}

	public void setSpeedKph(Double speedKph) {
		this.speedKph = speedKph;
	}

	public QFlag getqFlag() {
		return qFlag;
	}

	public void setqFlag(QFlag qFlag) {
		this.qFlag = qFlag;
	}

	public VFlag getvFlag() {
		return vFlag;
	}

	public void setvFlag(VFlag vFlag) {
		this.vFlag = vFlag;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}

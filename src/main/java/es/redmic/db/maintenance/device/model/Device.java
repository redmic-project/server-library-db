package es.redmic.db.maintenance.device.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.db.administrative.model.Document;
import es.redmic.db.administrative.model.Platform;
import es.redmic.db.common.model.UpdatableModel;
import es.redmic.db.maintenance.samples.model.Sample;

/**
 * The persistent class for the device database table.
 * 
 */
@Entity
@Table(name = "device")
@NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d")
public class Device extends UpdatableModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String model;

	@Column(nullable = false)
	private String name;

	@Column(length = 50)
	private String note;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private String serialnumber;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime manufactureddate;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime adquisitiondate;

	// bi-directional many-to-one association to Document
	@ManyToOne
	@JoinColumn(name = "documentid")
	private Document document;

	// bi-directional many-to-one association to Platform
	@ManyToOne
	@JoinColumn(name = "platformid")
	private Platform platform;

	// bi-directional many-to-one association to Calibration
	@OneToMany(mappedBy = "device", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<Calibration> calibrations;

	// bi-directional many-to-one association to Devicetype
	@ManyToOne
	@JoinColumn(name = "devicetypeid", nullable = false)
	private DeviceType devicetype;

	// bi-directional many-to-one association to Device
	/*@OneToMany(mappedBy = "device", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<DataDefinition> datadefinition;*/

	@OneToMany(mappedBy = "device")
	private Set<Sample> sample;

	public Device() {
	}

	public DateTime getAdquisitionDate() {
		return this.adquisitiondate;
	}

	public void setAdquisitionDate(DateTime adquisitiondate) {
		this.adquisitiondate = adquisitiondate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document documentid) {
		this.document = documentid;
	}

	public DateTime getManufacturedDate() {
		return this.manufactureddate;
	}

	public void setManufacturedDate(DateTime manufactureddate) {
		this.manufactureddate = manufactureddate;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platformid) {
		this.platform = platformid;
	}

	public String getSerialNumber() {
		return this.serialnumber;
	}

	public void setSerialNumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public Set<Calibration> getCalibrations() {
		return this.calibrations;
	}

	public void setCalibrations(Set<Calibration> calibrations) {
		this.calibrations = calibrations;
	}

	public Calibration addCalibration(Calibration calibration) {
		getCalibrations().add(calibration);
		calibration.setDevice(this);

		return calibration;
	}

	public Calibration removeCalibration(Calibration calibration) {
		getCalibrations().remove(calibration);
		calibration.setDevice(null);

		return calibration;
	}

	public DeviceType getDeviceType() {
		return this.devicetype;
	}

	public void setDeviceType(DeviceType devicetype) {
		this.devicetype = devicetype;
	}

	/*public Set<DataDefinition> getDatadefinition() {
		return datadefinition;
	}

	public void setDatadefinition(Set<DataDefinition> datadefinition) {
		this.datadefinition = datadefinition;
	}
	
	public DataDefinition addDatadefinition(DataDefinition datadefinition) {
		getDatadefinition().add(datadefinition);
		datadefinition.setDevice(this);

		return datadefinition;
	}

	public DataDefinition removeDatadefinition(DataDefinition datadefinition) {
		getDatadefinition().remove(datadefinition);
		datadefinition.setDevice(null);

		return datadefinition;
	}*/

	public Set<Sample> getSample() {
		return sample;
	}

	public void setSample(Set<Sample> sample) {
		this.sample = sample;
	}

}
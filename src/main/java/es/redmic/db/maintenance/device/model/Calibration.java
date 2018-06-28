package es.redmic.db.maintenance.device.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.administrative.model.Contact;

/**
 * The persistent class for the calibration database table.
 * 
 */
@Entity
@NamedQuery(name = "Calibration.findAll", query = "SELECT c FROM Calibration c")
public class Calibration extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String data;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime date;

	@Column(length = 50)
	private String method;

	@Column(length = 50)
	private String note;

	// bi-directional many-to-one association to Device
	@ManyToOne
	@JoinColumn(name = "deviceid")
	private Device device;

	// bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name = "contactid")
	private Contact contact;

	public Calibration() {
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public DateTime getDate() {
		return this.date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
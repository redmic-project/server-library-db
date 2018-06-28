package es.redmic.db.administrative.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.common.model.UpdatableModel;

/**
 * The persistent class for the embargo database table.
 * 
 */
@Entity
@Table(name = "embargo")
@NamedQuery(name = "Embargo.findAll", query = "SELECT e FROM Embargo e")
public class Embargo extends UpdatableModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Timestamp alert;

	private Timestamp enddate;

	@Column(length = 50)
	private String note;

	@Column(nullable = false)
	private Timestamp startdate;

	// bi-directional many-to-one association to Activity
	@OneToMany(mappedBy = "embargo")
	private List<Activity> activities;

	// bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name = "contactid")
	private Contact contact;

	// bi-directional many-to-one association to Document
	@ManyToOne
	@JoinColumn(name = "documentid")
	private Document document;

	// bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name = "organisationid")
	private Organisation organisation;

	public Timestamp getAlert() {
		return this.alert;
	}

	public void setAlert(Timestamp alert) {
		this.alert = alert;
	}

	public Timestamp getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public List<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		activity.setEmbargo(this);

		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		activity.setEmbargo(null);

		return activity;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

}
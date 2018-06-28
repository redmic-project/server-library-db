package es.redmic.db.administrative.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.maintenance.administrative.model.OrganisationRole;

/**
 * The persistent class for the activityorganisationrole database table.
 * 
 */
@Entity
@Table(name = "activityorganisationrole")
@NamedQuery(name = "ActivityOrganisationRole.findAll", query = "SELECT a FROM ActivityOrganisationRole a")
public class ActivityOrganisationRole extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "activityid", nullable = false)
	private ActivityBase activity;

	@ManyToOne
	@JoinColumn(name = "organisationid", nullable = false)
	private Organisation organisation;

	@ManyToOne
	@JoinColumn(name = "orgroleid", nullable = false)
	private OrganisationRole role;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime startdate;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime enddate;

	public ActivityOrganisationRole() {
	}

	public ActivityBase getActivity() {
		return this.activity;
	}

	public void setActivity(ActivityBase activityBase) {
		this.activity = activityBase;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public OrganisationRole getRole() {
		return this.role;
	}

	public void setRole(OrganisationRole organisationrole) {
		this.role = organisationrole;
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
}
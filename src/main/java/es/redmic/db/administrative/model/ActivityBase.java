package es.redmic.db.administrative.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.redmic.db.common.model.UpdatableModel;
import es.redmic.db.maintenance.administrative.model.ActivityRank;
import es.redmic.db.maintenance.administrative.model.Scope;
import es.redmic.db.maintenance.common.model.Accessibility;

@Entity
@Table(name = "activity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "activityrankid", discriminatorType = DiscriminatorType.INTEGER)
public class ActivityBase extends UpdatableModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String code;

	@Column(length = 50)
	private String description;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime enddate;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(length = 50)
	private String note;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime startdate;

	@Column(length = 500)
	private String urlmapservice;

	// bi-directional many-to-one association to Taxon
	@ManyToOne
	@JoinColumn(name = "parentid")
	private ActivityBase parent;

	// bi-directional many-to-one association to Rank
	@ManyToOne
	@JoinColumn(name = "activityrankid", insertable = false, updatable = false, nullable=false)	
	private ActivityRank activityRank;

	// bi-directional many-to-one association to Accessibility
	@ManyToOne
	@JoinColumn(name = "accesibilityid", nullable = false)
	private Accessibility accessibility;

	// bi-directional many-to-one association to Scope
	@ManyToOne
	@JoinColumn(name = "scopeid", nullable = false)
	private Scope scope;

	// bi-directional many-to-one association to Activitycontactrole
	@OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ActivityContactRole> contacts = new HashSet<ActivityContactRole>();

	// bi-directional many-to-one association to Activitycontactrole
	@OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ActivityOrganisationRole> organisations = new HashSet<ActivityOrganisationRole>();

	// bi-directional many-to-one association to Activitydocument
	@OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ActivityDocument> documents = new HashSet<ActivityDocument>();

	// bi-directional many-to-one association to Activityplatform
	@OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ActivityPlatformRole> platforms = new HashSet<ActivityPlatformRole>();
	
	@Column(insertable = false, updatable = false)
	private String path;

	public ActivityBase() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateTime getEndDate() {
		return this.enddate;
	}

	public void setEndDate(DateTime enddate) {
		this.enddate = enddate;
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

	public DateTime getStartDate() {
		return this.startdate;
	}

	public void setStartDate(DateTime startdate) {
		this.startdate = startdate;
	}

	public String getUrlMapService() {
		return this.urlmapservice;
	}

	public void setUrlMapService(String urlmapservice) {
		this.urlmapservice = urlmapservice;
	}

	public ActivityBase getParent() {
		return this.parent;
	}

	public void setParent(ActivityBase parent) {
		this.parent = parent;
	}

	public ActivityRank getActivityRank() {
		return activityRank;
	}

	@JsonIgnore
	public void setActivityRank(ActivityRank activityrank) {
		this.activityRank = activityrank;
	}

	public Accessibility getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(Accessibility accessibility) {
		this.accessibility = accessibility;

	}

	public Scope getScope() {
		return this.scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public Set<ActivityContactRole> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<ActivityContactRole> activityContactRoles) {
		
		this.contacts.clear();
		
		if (activityContactRoles == null)
			return;
		
		for (ActivityContactRole contact : activityContactRoles)
			addContact(contact);
	}

	public ActivityContactRole addContact(ActivityContactRole activitycontactrole) {
		activitycontactrole.setActivity(this);
		getContacts().add(activitycontactrole);
		return activitycontactrole;
	}

	public Set<ActivityOrganisationRole> getOrganisations() {
		return this.organisations;
	}

	public void setOrganisations(Set<ActivityOrganisationRole> activityOrganisationRoles) {
		
		this.organisations.clear();
		
		if (activityOrganisationRoles == null)
			return;
		
		for (ActivityOrganisationRole organisation: activityOrganisationRoles)
			addOrganisation(organisation);
	}

	public ActivityOrganisationRole addOrganisation(ActivityOrganisationRole activityorganisationrole) {
		activityorganisationrole.setActivity(this);
		getOrganisations().add(activityorganisationrole);
		return activityorganisationrole;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Set<ActivityDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<ActivityDocument> activityDocuments) {
		
		this.documents.clear();
		
		if (activityDocuments == null)
			return;
		
		for (ActivityDocument document: activityDocuments)
			addDocument(document);
	}

	public ActivityDocument addDocument(ActivityDocument activityDocuments) {
		activityDocuments.setActivity(this);
		getDocuments().add(activityDocuments);
		return activityDocuments;
	}

	public Set<ActivityPlatformRole> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(Set<ActivityPlatformRole> activityPlatforms) {

		this.platforms.clear();
		
		if (activityPlatforms == null)
			return;
		
		for (ActivityPlatformRole platform: activityPlatforms)
			addPlatform(platform);
	}

	public ActivityPlatformRole addPlatform(ActivityPlatformRole activityPlatforms) {
		activityPlatforms.setActivity(this);
		getPlatforms().add(activityPlatforms);
		return activityPlatforms;
	}
}

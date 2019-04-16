package es.redmic.db.administrative.model;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.common.model.UpdatableModel;
import es.redmic.db.maintenance.administrative.model.OrganisationType;

/**
 * The persistent class for the organisation database table.
 * 
 */
@Entity
@Table(name = "organisation")
@NamedQuery(name = "Organisation.findAll", query = "SELECT o FROM Organisation o")
public class Organisation extends UpdatableModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String acronym;

	@Column(length = 50)
	private String address;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private String email;

	@Column(length = 150)
	private String logo;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(length = 50)
	private String note;

	private String phone;

	@Column(length = 50)
	private String webpage;

	// bi-directional many-to-one association to Activitycontactrole
	@OneToMany(mappedBy = "organisation")
	private Set<ActivityContactRole> activitycontactroles;

	// bi-directional many-to-one association to Contact
	@OneToMany(mappedBy = "organisation")
	private Set<Contact> contacts;

	// bi-directional many-to-one association to Embargo
	@OneToMany(mappedBy = "organisation")
	private Set<Embargo> embargos;

	// bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name = "countryid")
	private Country country;

	// bi-directional many-to-one association to Organisationtype
	@ManyToOne
	@JoinColumn(name = "organisationtypeid", nullable = false)
	private OrganisationType organisationtype;

	// bi-directional many-to-one association to Platform
	@OneToMany(mappedBy = "organisation")
	private Set<Platform> platforms;

	// bi-directional many-to-one association to activityorganisationrole
	@OneToMany(mappedBy = "organisation")
	private Set<ActivityOrganisationRole> activityorganisationroles;

	public Organisation() {
	}

	public String getAcronym() {
		return this.acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebpage() {
		return this.webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public Set<ActivityContactRole> getActivitycontactroles() {
		return this.activitycontactroles;
	}

	public void setActivitycontactroles(Set<ActivityContactRole> activitycontactroles) {
		this.activitycontactroles = activitycontactroles;
	}

	public ActivityContactRole addActivitycontactrole(ActivityContactRole activitycontactrole) {
		getActivitycontactroles().add(activitycontactrole);
		activitycontactrole.setOrganisation(this);

		return activitycontactrole;
	}

	public ActivityContactRole removeActivitycontactrole(ActivityContactRole activitycontactrole) {
		getActivitycontactroles().remove(activitycontactrole);
		activitycontactrole.setOrganisation(null);

		return activitycontactrole;
	}

	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setOrganisation(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setOrganisation(null);

		return contact;
	}

	public Set<Embargo> getEmbargos() {
		return this.embargos;
	}

	public void setEmbargos(Set<Embargo> embargos) {
		this.embargos = embargos;
	}

	public Embargo addEmbargo(Embargo embargo) {
		getEmbargos().add(embargo);
		embargo.setOrganisation(this);

		return embargo;
	}

	public Embargo removeEmbargo(Embargo embargo) {
		getEmbargos().remove(embargo);
		embargo.setOrganisation(null);

		return embargo;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public OrganisationType getOrganisationType() {
		return this.organisationtype;
	}

	public void setOrganisationType(OrganisationType organisationtype) {
		this.organisationtype = organisationtype;
	}

	public Set<Platform> getPlatforms() {
		return this.platforms;
	}

	public void setPlatforms(Set<Platform> platforms) {
		this.platforms = platforms;
	}

	public Platform addPlatform(Platform platform) {
		getPlatforms().add(platform);
		platform.setOrganisation(this);

		return platform;
	}

	public Platform removePlatform(Platform platform) {
		getPlatforms().remove(platform);
		platform.setOrganisation(null);

		return platform;
	}

	public Set<ActivityOrganisationRole> getActivityorganisationroles() {
		return this.activityorganisationroles;
	}

	public void setActivityorganisationroles(Set<ActivityOrganisationRole> activityorganisationroles) {
		this.activityorganisationroles = activityorganisationroles;
	}

	public ActivityOrganisationRole addActivityorganisationrole(ActivityOrganisationRole activityorganisationrole) {
		getActivityorganisationroles().add(activityorganisationrole);
		activityorganisationrole.setOrganisation(this);

		return activityorganisationrole;
	}

	public ActivityOrganisationRole removeActivityorganisationrole(ActivityOrganisationRole activityorganisationrole) {
		getActivityorganisationroles().remove(activityorganisationrole);
		activityorganisationrole.setOrganisation(null);

		return activityorganisationrole;
	}
}

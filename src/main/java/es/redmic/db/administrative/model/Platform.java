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
import java.util.HashSet;
import java.util.List;
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

import es.redmic.db.common.model.UuidModel;
import es.redmic.db.maintenance.administrative.model.PlatformType;
import es.redmic.db.maintenance.device.model.Device;

/**
 * The persistent class for the platform database table.
 * 
 */
@Entity
@Table(name = "platform")
@NamedQuery(name = "Platform.findAll", query = "SELECT p FROM Platform p")
public class Platform extends UuidModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String contactphone;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private String image;

	@Column(length = 50)
	private String licence;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(length = 50)
	private String note;

	@Column(length = 50)
	private String seawebcode;

	// bi-directional many-to-one association to Activityplatform
	@OneToMany(mappedBy = "platform")
	private List<ActivityPlatformRole> activityplatforms;

	// bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name = "organisationid")
	private Organisation organisation;

	// bi-directional many-to-one association to Device
	@OneToMany(mappedBy = "platform")
	private Set<Device> device;

	// bi-directional many-to-one association to Platformtype
	@ManyToOne
	@JoinColumn(name = "platformtypeid", nullable = false)
	private PlatformType platformtype;

	// bi-directional many-to-one association to Platformcontactrole
	@OneToMany(mappedBy = "platform", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PlatformContactRole> contacts = new HashSet<PlatformContactRole>();

	public Platform() {
	}

	public String getContactPhone() {
		return this.contactphone;
	}

	public void setContactPhone(String contactphone) {
		this.contactphone = contactphone;
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

	public String getLicence() {
		return this.licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
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

	public String getSeaWebCode() {
		return this.seawebcode;
	}

	public void setSeaWebCode(String seawebcode) {
		this.seawebcode = seawebcode;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public List<ActivityPlatformRole> getActivityplatforms() {
		return this.activityplatforms;
	}

	public void setActivityplatforms(List<ActivityPlatformRole> activityplatforms) {
		this.activityplatforms = activityplatforms;
	}

	public PlatformType getPlatformType() {
		return this.platformtype;
	}

	public void setPlatformType(PlatformType platformtype) {
		this.platformtype = platformtype;
	}

	public Set<PlatformContactRole> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<PlatformContactRole> contacts) {
		
		this.contacts.clear();
		
		if (contacts == null)
			return;
		for (PlatformContactRole contact : contacts)
			addContact(contact);	
	}

	public PlatformContactRole addContact(PlatformContactRole contacts) {
		contacts.setPlatform(this);
		getContacts().add(contacts);
		return contacts;
	}
}

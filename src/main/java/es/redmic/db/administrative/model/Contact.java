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
import es.redmic.db.maintenance.device.model.Calibration;

/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name = "contact")
@NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
public class Contact extends UpdatableModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String email;

	@Column(nullable = false, length = 50)
	private String firstname;

	@Column(length = 50)
	private String image;

	@Column(length = 50)
	private String mobile;

	@Column(length = 50)
	private String note;

	@Column(length = 50)
	private String phone;

	@Column(nullable = false, length = 50)
	private String surname;

	// bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name = "affiliationid")
	private Organisation organisation;

	// bi-directional many-to-one association to Embargo
	@OneToMany(mappedBy = "contact")
	private Set<Embargo> embargos;

	// bi-directional many-to-one association to Platformcontactrole
	@OneToMany(mappedBy = "contact")
	private Set<PlatformContactRole> platformcontactroles;

	// bi-directional many-to-one association to Activitycontactrole
	@OneToMany(mappedBy = "contact")
	private Set<ActivityContactRole> activitycontactroles;

	// bi-directional many-to-one association to Calibration
	@OneToMany(mappedBy = "contact")
	private Set<Calibration> calibrations;

	public Contact() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Set<Embargo> getEmbargos() {
		return this.embargos;
	}

	public void setEmbargos(Set<Embargo> embargos) {
		this.embargos = embargos;
	}

	public Embargo addEmbargo(Embargo embargo) {
		getEmbargos().add(embargo);
		embargo.setContact(this);

		return embargo;
	}

	public Embargo removeEmbargo(Embargo embargo) {
		getEmbargos().remove(embargo);
		embargo.setContact(null);

		return embargo;
	}

	public Set<PlatformContactRole> getPlatformcontactroles() {
		return this.platformcontactroles;
	}

	public void setPlatformcontactroles(Set<PlatformContactRole> platformcontactroles) {
		this.platformcontactroles = platformcontactroles;
	}

	public PlatformContactRole addPlatformcontactrole(PlatformContactRole platformcontactrole) {
		getPlatformcontactroles().add(platformcontactrole);
		platformcontactrole.setContact(this);

		return platformcontactrole;
	}

	public PlatformContactRole removePlatformcontactrole(PlatformContactRole platformcontactrole) {
		getPlatformcontactroles().remove(platformcontactrole);
		platformcontactrole.setContact(null);

		return platformcontactrole;
	}

	public Set<ActivityContactRole> getActivitycontactroles() {
		return this.activitycontactroles;
	}

	public void setActivitycontactroles(Set<ActivityContactRole> activitycontactroles) {
		this.activitycontactroles = activitycontactroles;
	}

	public ActivityContactRole addActivitycontactrole(ActivityContactRole activitycontactrole) {
		getActivitycontactroles().add(activitycontactrole);
		activitycontactrole.setContact(this);

		return activitycontactrole;
	}

	public ActivityContactRole removeActivitycontactrole(ActivityContactRole activitycontactrole) {
		getActivitycontactroles().remove(activitycontactrole);
		activitycontactrole.setContact(null);

		return activitycontactrole;
	}

	/* Calibrations */
	public Set<Calibration> getCalibrations() {
		return this.calibrations;
	}

	public void setCalibrations(Set<Calibration> calibrations) {
		this.calibrations = calibrations;
	}

	public Calibration addCalibration(Calibration calibration) {
		getCalibrations().add(calibration);
		calibration.setContact(this);

		return calibration;
	}

	public Calibration removeCalibration(Calibration calibration) {
		getCalibrations().remove(calibration);
		calibration.setContact(null);

		return calibration;
	}

}

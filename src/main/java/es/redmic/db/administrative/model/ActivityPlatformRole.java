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

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.maintenance.administrative.model.ContactRole;

/**
 * The persistent class for the activityplatform database table.
 * 
 */
@Entity
@Table(name = "activityplatformrole")
@NamedQuery(name = "ActivityPlatformRole.findAll", query = "SELECT a FROM ActivityPlatformRole a")
public class ActivityPlatformRole extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "activityid", nullable = false)
	private ActivityBase activity;

	@ManyToOne
	@JoinColumn(name = "platformid", nullable = false)
	private Platform platform;

	@ManyToOne
	@JoinColumn(name = "contactid", nullable = false)
	private Contact contact;

	@ManyToOne
	@JoinColumn(name = "contactroleid", nullable = false)
	private ContactRole role;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime startdate;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime enddate;

	public ActivityPlatformRole() {
	}

	public ActivityBase getActivity() {
		return this.activity;
	}

	public void setActivity(ActivityBase activityBase) {
		this.activity = activityBase;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ContactRole getRole() {
		return this.role;
	}

	public void setRole(ContactRole contactrole) {
		this.role = contactrole;
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

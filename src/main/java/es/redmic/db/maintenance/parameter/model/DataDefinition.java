package es.redmic.db.maintenance.parameter.model;

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
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.administrative.model.Contact;
import es.redmic.db.maintenance.administrative.model.ContactRole;
import es.redmic.db.maintenance.device.model.Device;

/**
 * The persistent class for the datadefinition database table.
 * 
 */
@Entity
@Table(name="datadefinition")
@NamedQuery(name = "DataDefinition.findAll", query = "SELECT d FROM DataDefinition d")
public class DataDefinition extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Boolean deriveddata = false;

	@Column(length = 1500, nullable = false)
	private String description;

	private BigDecimal maxvalue;

	private BigDecimal minvalue;

	private Integer significantdigits;

	@ManyToOne
	@JoinColumn(name = "deviceid")
	private Device device;
	
	@ManyToOne
	@JoinColumn(name = "contactid")
	private Contact contact;
	
	// bi-directional many-to-one association to Contactrole
	@ManyToOne
	@JoinColumn(name = "contactroleid")
	private ContactRole contactrole;

	// bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name = "parameterunitid", nullable = false)
	private ParameterUnit parameterunit;

	private Long timeinterval;
	
	private Boolean isserial = false;

	private Boolean isregularity = false;

	public Boolean getDerivedData() {
		return this.deriveddata;
	}

	public void setDerivedData(Boolean deriveddata) {
		if (deriveddata != null)
			this.deriveddata = deriveddata;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getMaxValue() {
		return this.maxvalue;
	}

	public void setMaxValue(BigDecimal maxvalue) {
		this.maxvalue = maxvalue;
	}

	public BigDecimal getMinValue() {
		return this.minvalue;
	}

	public void setMinValue(BigDecimal minvalue) {
		this.minvalue = minvalue;
	}

	public Integer getSignificantDigits() {
		return this.significantdigits;
	}

	public void setSignificantDigits(Integer significantdigits) {
		this.significantdigits = significantdigits;
	}

	public Device getDevice() {
		return device;
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

	public ContactRole getContactRole() {
		return this.contactrole;
	}

	public void setContactRole(ContactRole contactrole) {
		this.contactrole = contactrole;
	}

	public ParameterUnit getParameterUnit() {
		return parameterunit;
	}

	public void setParameterUnit(ParameterUnit parameterunit) {
		this.parameterunit = parameterunit;
	}

	public Long getTimeInterval() {
		return this.timeinterval;
	}

	public void setTimeInterval(Long timeinterval) {
		this.timeinterval = timeinterval;
	}

	public Boolean getIsSerial() {
		return isserial;
	}

	public void setIsSerial(Boolean isserial) {
		if (isserial != null)
			this.isserial = isserial;
	}

	public Boolean getIsRegularity() {
		return this.isregularity;
	}

	public void setIsRegularity(Boolean regularity) {
		if (regularity != null)
			this.isregularity = regularity;
	}
}

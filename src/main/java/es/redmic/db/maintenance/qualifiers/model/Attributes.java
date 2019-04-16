package es.redmic.db.maintenance.qualifiers.model;

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

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.db.series.common.model.SeriesBase;

@MappedSuperclass
public abstract class Attributes extends SeriesBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "attributetypeid", nullable = false)
	private AttributeType attributeType;

	private String remark;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime startdate;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime enddate;

	public AttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

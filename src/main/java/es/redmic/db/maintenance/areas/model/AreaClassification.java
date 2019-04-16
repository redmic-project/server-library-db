package es.redmic.db.maintenance.areas.model;

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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.geodata.area.model.Area;

/**
 * The persistent class for the classificationsector database table.
 * 
 */
@Entity
@Table(name = "areaclassification")
@NamedQuery(name = "AreaClassification.findAll", query = "SELECT c FROM AreaClassification c")
public class AreaClassification extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 1500)
	private String remark;

	@ManyToOne
	@JoinColumn(name = "areaid", nullable = false)
	private Area area;

	@ManyToOne
	@JoinColumn(name = "thematictypeid", nullable = false)
	private ThematicType thematicType;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime startdate;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime enddate;

	public AreaClassification() {
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public ThematicType getThematicType() {
		return thematicType;
	}

	public void setThematicType(ThematicType thematicType) {
		this.thematicType = thematicType;
	}

	public DateTime getStartDate() {
		return startdate;
	}

	public void setStartDate(DateTime startdate) {
		this.startdate = startdate;
	}

	public DateTime getEndDate() {
		return enddate;
	}

	public void setEndDate(DateTime enddate) {
		this.enddate = enddate;
	}
}

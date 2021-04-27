package es.redmic.db.geodata.tracking.platform.model;

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

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.administrative.model.Platform;
import es.redmic.db.geodata.tracking.common.model.BaseTracking;

/**
 * The persistent class for the platformtracking.
 * 
 */
@Entity
@Table(name = "platformtracking")
@NamedQuery(name = "PlatformTracking.findAll", query = "SELECT c FROM PlatformTracking c")
public class PlatformTracking extends BaseTracking {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1278743955707145193L;
		
	@ManyToOne
	@JoinColumn(name = "platformid")
	private Platform platform;
	
	private String remark;

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}

package es.redmic.db.maintenance.administrative.model;

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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;

/**
 * The persistent class for the activityrank database table.
 * 
 */
@Entity
@Table(name = "activityrank")
@NamedQuery(name = "ActivityRank.findAll", query = "SELECT a FROM ActivityRank a")
public class ActivityRank extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	@Column(name = "name_en")
	private String nameEn;

	public ActivityRank() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

}

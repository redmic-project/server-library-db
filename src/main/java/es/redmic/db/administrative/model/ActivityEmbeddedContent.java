package es.redmic.db.administrative.model;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 - 2021 REDMIC Project / Server
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

import es.redmic.databaselib.common.model.LongModel;

/**
 * The persistent class for the activityembeddedcontent database table.
 *
 */
@Entity
@Table(name = "activityembeddedcontent")
@NamedQuery(name = "ActivityEmbeddedContent.findAll", query = "SELECT a FROM ActivityEmbeddedContent a")
public class ActivityEmbeddedContent extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "activityid", nullable = false)
	private ActivityBase activity;

	@Column(name = "embeddedcontent", length = 50000)
	private String embeddedcontent;

	public ActivityEmbeddedContent() {
		// Constructor por defecto para que accedan los mappers
	}

	public ActivityBase getActivity() {
		return this.activity;
	}

	public void setActivity(ActivityBase activityBase) {
		this.activity = activityBase;
	}

	public String getEmbeddedContent() {
		return this.embeddedcontent;
	}

	public void setEmbeddedContent(String embeddedcontent) {
		this.embeddedcontent = embeddedcontent;
	}
}

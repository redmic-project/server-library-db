package es.redmic.db.geodata.toponym.model;

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

import org.locationtech.jts.geom.Point;

import es.redmic.db.common.model.UuidModel;
import es.redmic.db.maintenance.toponym.model.ToponymType;

/**
 * The persistent class for the citation database view.
 *
 */
@Entity
@Table(name = "toponym")
@NamedQuery(name = "Toponym.findAll", query = "SELECT c FROM Toponym c")
public class Toponym extends UuidModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	@Column(nullable = false)
	private String description;

	@Column(name = "zoomlevel")
	private Integer zoomLevel;

	@ManyToOne
	@JoinColumn(name = "toponymtypeid")
	private ToponymType toponymType;

	@Column(name = "shape", nullable = false)
	Point geometry;

	public Toponym() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getZoomLevel() {
		return zoomLevel;
	}

	public void setZoomLevel(Integer zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

	public ToponymType getToponymType() {
		return toponymType;
	}

	public void setToponymType(ToponymType toponymType) {
		this.toponymType = toponymType;
	}

	public Point getGeometry() {
		return geometry;
	}

	public void setGeometry(Point geometry) {
		this.geometry = geometry;
		this.geometry.setSRID(4326);
	}
}

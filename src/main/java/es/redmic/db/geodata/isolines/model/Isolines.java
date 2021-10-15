package es.redmic.db.geodata.isolines.model;

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

import org.locationtech.jts.geom.MultiLineString;

import es.redmic.db.geodata.common.model.GeoDataModel;
import es.redmic.db.maintenance.line.model.LineType;
import es.redmic.db.maintenance.parameter.model.DataDefinition;
import es.redmic.db.maintenance.quality.model.QFlag;
import es.redmic.db.maintenance.quality.model.VFlag;

@Entity
@Table(name = "isolines")
@NamedQuery(name = "Isolines.findAll", query = "SELECT i FROM Isolines i")
public class Isolines extends GeoDataModel implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "shape", nullable = false)
	MultiLineString geometry;

	Double value;

	Double z;

	@ManyToOne
	@JoinColumn(name = "qflag")
	private QFlag qFlag;

	@ManyToOne
	@JoinColumn(name = "vflag")
	private VFlag vFlag;

	@ManyToOne
	@JoinColumn(name = "datadefinitionid")
	DataDefinition dataDefinition;

	@ManyToOne
	@JoinColumn(name = "linetypeid")
	LineType lineType;

	public MultiLineString getGeometry() {
		return geometry;
	}

	public void setGeometry(MultiLineString geometry) {
		this.geometry = geometry;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public QFlag getqFlag() {
		return qFlag;
	}

	public void setqFlag(QFlag qFlag) {
		this.qFlag = qFlag;
	}

	public VFlag getvFlag() {
		return vFlag;
	}

	public void setvFlag(VFlag vFlag) {
		this.vFlag = vFlag;
	}

	public DataDefinition getDataDefinition() {
		return dataDefinition;
	}

	public void setDataDefinition(DataDefinition dataDefinition) {
		this.dataDefinition = dataDefinition;
	}

	public LineType getLineType() {
		return lineType;
	}

	public void setLineType(LineType lineType) {
		this.lineType = lineType;
	}

}

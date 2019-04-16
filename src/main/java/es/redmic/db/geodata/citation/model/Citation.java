package es.redmic.db.geodata.citation.model;

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

import com.vividsolutions.jts.geom.Point;

import es.redmic.db.administrative.taxonomy.model.Misidentification;
import es.redmic.db.administrative.taxonomy.model.Taxon;
import es.redmic.db.geodata.common.domain.model.Confidence;
import es.redmic.db.geodata.common.model.GeoDataModel;

/**
 * The persistent class for the citation database view.
 * 
 */
@Entity
@Table(name = "citation")
@NamedQuery(name = "Citation.findAll", query = "SELECT c FROM Citation c")
public class Citation extends GeoDataModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	@Column(nullable = false)
	private DateTime startdate;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	@Column(nullable = false)
	private DateTime enddate;

	private String collectorname;

	private String remark;

	private Integer specimencount;

	// bi-directional many-to-one association to Confidence
	@ManyToOne
	@JoinColumn(name = "confidenceid")
	private Confidence confidence;

	private String code;

	private String name;

	private Double radius;
	
	@Column(name = "shape", nullable = false)
	Point geometry;

	@Column(name="z")
	private Double z;
	
	private Double deviation;

	// bi-directional many-to-one association to Confidence
	@ManyToOne
	@JoinColumn(name = "speciesconfidenceid")
	private Confidence speciesconfidence;

	// bi-directional many-to-one association to SpeciesEquivalence
	@ManyToOne
	@JoinColumn(name = "taxonid")
	private Taxon taxon;
	
	// bi-directional many-to-one association to SpeciesEquivalence
	@ManyToOne
	@JoinColumn(name = "misidentificationid")
	private Misidentification misidentification;

	public Citation() {
		super();
	}

	public DateTime getStartDate() {
		return startdate;
	}

	public void setStartDate(DateTime startDate) {
		this.startdate = startDate;
	}

	public DateTime getEndDate() {
		return enddate;
	}

	public void setEndDate(DateTime endDate) {
		this.enddate = endDate;
	}

	public String getCollectorName() {
		return this.collectorname;
	}

	public void setCollectorName(String collectorname) {
		this.collectorname = collectorname;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSpecimenCount() {
		return this.specimencount;
	}

	public void setSpecimenCount(Integer specimencount) {
		this.specimencount = specimencount;
	}

	public Confidence getConfidence() {
		return this.confidence;
	}

	public void setConfidence(Confidence confidence) {
		this.confidence = confidence;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRadius() {
		return this.radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Point getGeometry() {
		return geometry;
	}

	public void setGeometry(Point geometry) {
		this.geometry = geometry;
		this.geometry.setSRID(4326);
	}

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public Double getDeviation() {
		return deviation;
	}

	public void setDeviation(Double deviation) {
		this.deviation = deviation;
	}

	public Confidence getSpeciesConfidence() {
		return this.speciesconfidence;
	}

	public void setSpeciesConfidence(Confidence speciesconfidence) {
		this.speciesconfidence = speciesconfidence;
	}

	public Taxon getTaxon() {
		return taxon;
	}

	public void setTaxon(Taxon taxon) {
		this.taxon = taxon;
	}
	
	public Misidentification getMisidentification() {
		return misidentification;
	}

	public void setMisidentification(Misidentification misidentification) {
		this.misidentification = misidentification;
	}
}

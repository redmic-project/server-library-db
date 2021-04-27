package es.redmic.db.series.objectcollecting.model;

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
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.db.geodata.common.domain.model.Confidence;
import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.db.series.common.model.SeriesBase;

/**
 * The persistent class for the objectcollecting database table.
 * 
 */
@Entity
@Table(name = "objectcollecting")
@NamedQuery(name = "ObjectCollecting.findAll", query = "SELECT o FROM ObjectCollecting o")
public class ObjectCollecting extends SeriesBase implements Serializable {
	private static final long serialVersionUID = 1L;

	private double z;

	@Column(nullable = false)
	private double value;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	@Column(nullable = false)
	private DateTime date;

	@Column(length = 1500)
	private String remark;

	@Column(length = 150)
	private String image;

	@ManyToOne
	@JoinColumn(name = "measurementid", nullable = false)
	private FixedMeasurement fixedMeasurement;

	@OneToMany(mappedBy = "objectCollecting", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ObjectCollectingClassification> objectCollectingClassification = new ArrayList<ObjectCollectingClassification>();

	@ManyToOne
	@JoinColumn(name = "confidenceid")
	private Confidence confidence;

	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public DateTime getDate() {
		return this.date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public FixedMeasurement getFixedMeasurement() {
		return fixedMeasurement;
	}

	public void setFixedMeasurement(FixedMeasurement fixedMeasurement) {
		this.fixedMeasurement = fixedMeasurement;
	}

	public List<ObjectCollectingClassification> getObjectCollectingClassification() {
		return objectCollectingClassification;
	}

	public void setObjectCollectingClassification(List<ObjectCollectingClassification> objectCollectingClassification) {

		this.objectCollectingClassification.clear();

		if (objectCollectingClassification == null)
			return;

		this.objectCollectingClassification.addAll(objectCollectingClassification);
	}

	public ObjectCollectingClassification addObjectCollectingClassification(
			ObjectCollectingClassification objectCollectingClassification) {
		getObjectCollectingClassification().add(objectCollectingClassification);
		objectCollectingClassification.setObjectCollecting(this);

		return objectCollectingClassification;
	}

	public ObjectCollectingClassification removeObjectCollectingClassification(
			ObjectCollectingClassification objectCollectingClassification) {
		getObjectCollectingClassification().remove(objectCollectingClassification);
		objectCollectingClassification.setObjectCollecting(null);

		return objectCollectingClassification;
	}

	public Confidence getConfidence() {
		return confidence;
	}

	public void setConfidence(Confidence confidence) {
		this.confidence = confidence;
	}
}

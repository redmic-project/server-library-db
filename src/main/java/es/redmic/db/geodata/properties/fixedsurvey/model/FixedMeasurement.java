package es.redmic.db.geodata.properties.fixedsurvey.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.maintenance.parameter.model.DataDefinition;

/**
 * The persistent class for the measurement database table.
 * 
 */
@Entity
@Table(name = "fixedmeasurement")
@NamedQuery(name = "FixedMeasurement.findAll", query = "SELECT m FROM FixedMeasurement m")
public class FixedMeasurement extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private double z;

	// bi-directional many-to-one association to Surveystation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fixedsurveyid", nullable = false)
	private FixedSurvey fixedSurvey;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "datadefinitionid", nullable = false, unique = true)
	private DataDefinition dataDefinition;

	public FixedMeasurement() {
	}

	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public FixedSurvey getFixedSurvey() {
		return fixedSurvey;
	}

	public void setFixedSurvey(FixedSurvey fixedSurvey) {
		this.fixedSurvey = fixedSurvey;
	}

	public DataDefinition getDataDefinition() {
		return dataDefinition;
	}

	public void setDataDefinition(DataDefinition dataDefinition) {
		this.dataDefinition = dataDefinition;
	}
}
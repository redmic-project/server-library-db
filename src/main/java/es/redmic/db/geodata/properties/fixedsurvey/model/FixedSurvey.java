package es.redmic.db.geodata.properties.fixedsurvey.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Geometry;

import es.redmic.db.geodata.common.model.GeoDataModel;


/**
 * The persistent class for the surveystation database table.
 * 
 */
@Entity
@Table(name="fixedsurvey")
@NamedQuery(name="FixedSurvey.findAll", query="SELECT s FROM FixedSurvey s")
public class FixedSurvey extends GeoDataModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String code;

	@Column(length = 250)
	private String description;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 2, nullable = false)
	private String prefixtype;

	@Column(name = "shape", nullable = false)
	Geometry geometry;
	
	//bi-directional many-to-one association to Timeseries
	@OneToMany(mappedBy="fixedSurvey", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<FixedMeasurement> fixedMeasurements;

	public FixedSurvey() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefixType() {
		return prefixtype;
	}

	public void setPrefixType(String prefixtype) {
		this.prefixtype = prefixtype;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
		this.geometry.setSRID(4326);
	}
	
	public List<FixedMeasurement> getFixedMeasurement() {
		return this.fixedMeasurements;
	}

	public void setFixedMeasurement(List<FixedMeasurement> fixedMeasurements) {
		this.fixedMeasurements = fixedMeasurements;
	}

	public FixedMeasurement addTimeSeries(FixedMeasurement fixedMeasurements) {
		getFixedMeasurement().add(fixedMeasurements);
		fixedMeasurements.setFixedSurvey(this);

		return fixedMeasurements;
	}

	public FixedMeasurement removeTimeSeries(FixedMeasurement fixedMeasurements) {
		getFixedMeasurement().remove(fixedMeasurements);
		fixedMeasurements.setFixedSurvey(null);

		return fixedMeasurements;
	}
}
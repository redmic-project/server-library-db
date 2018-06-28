package es.redmic.db.geodata.area.model;

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
import javax.persistence.Transient;

import com.vividsolutions.jts.geom.MultiPolygon;

import es.redmic.db.geodata.common.model.GeoDataModel;
import es.redmic.db.maintenance.areas.model.AreaClassification;
import es.redmic.db.maintenance.areas.model.AreaType;

/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@Table(name = "area")
@NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
public class Area extends GeoDataModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Transient
	private String path;

	@ManyToOne
	@JoinColumn(name = "parentid")
	private Area parent;

	private String code;

	private String description;

	private Boolean legalvalidity;

	private String name;

	private String remark;

	@Column(name = "shape", nullable = false)
	MultiPolygon geometry;

	@ManyToOne
	@JoinColumn(name = "areatypeid")
	private AreaType areaType;

	@OneToMany(mappedBy = "area", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AreaClassification> areaClassification = new ArrayList<AreaClassification>();

	public Area() {
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Area getParent() {
		return parent;
	}

	public void setParent(Area parent) {
		this.parent = parent;
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

	public Boolean getLegalvalidity() {
		return this.legalvalidity;
	}

	public void setLegalvalidity(Boolean legalvalidity) {
		this.legalvalidity = legalvalidity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public MultiPolygon getGeometry() {
		return geometry;
	}

	public void setGeometry(MultiPolygon geometry) {

		this.geometry = geometry;

		if (this.geometry != null)
			this.geometry.setSRID(4326);
	}

	public AreaType getAreaType() {
		return this.areaType;
	}

	public void setAreaType(AreaType areaType) {
		this.areaType = areaType;
	}

	public List<AreaClassification> getAreaClassification() {
		return areaClassification;
	}

	public void setAreaClassification(List<AreaClassification> areaClassification) {

		this.areaClassification.clear();

		if (areaClassification == null)
			return;

		for (AreaClassification classification : areaClassification)
			addAreaClassification(classification);
	}

	public AreaClassification addAreaClassification(AreaClassification areaClassification) {
		areaClassification.setArea(this);
		getAreaClassification().add(areaClassification);
		return areaClassification;
	}
}
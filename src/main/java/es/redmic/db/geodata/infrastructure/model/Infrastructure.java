package es.redmic.db.geodata.infrastructure.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Point;

import es.redmic.db.geodata.common.model.GeoDataModel;
import es.redmic.db.maintenance.point.model.InfrastructureType;

@Entity
@Table(name = "infrastructurepoint")
@NamedQuery(name = "Infrastructure.findAll", query = "SELECT i FROM Infrastructure i")
public class Infrastructure extends GeoDataModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "shape", nullable = false)
	Point geometry;

	private Date date;

	private String code;

	private String name;

	private String description;

	private String remark;

	private Double rotate;

	private Double z;

	private String url;

	@ManyToOne
	@JoinColumn(name = "infrastructurepointtypeid")
	private InfrastructureType infrastructureType;

	public Point getGeometry() {
		return geometry;
	}

	public void setGeometry(Point geometry) {
		this.geometry = geometry;
		this.geometry.setSRID(4326);
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getRotate() {
		return rotate;
	}

	public void setRotate(Double rotate) {
		this.rotate = rotate;
	}

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public InfrastructureType getInfrastructureType() {
		return infrastructureType;
	}

	public void setInfrastructureType(InfrastructureType infrastructureType) {
		this.infrastructureType = infrastructureType;
	}
}
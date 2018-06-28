package es.redmic.db.geodata.toponym.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Point;

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
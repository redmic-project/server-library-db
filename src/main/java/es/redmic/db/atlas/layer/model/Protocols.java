package es.redmic.db.atlas.layer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;

@Entity
@Table(name = "protocols")
@NamedQuery(name = "Protocols.findAll", query = "SELECT p FROM Protocols p")
public class Protocols extends LongModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String type;
	
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "servicewmsid", nullable = false)
	private Layer layer;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Layer getLayer() {
		return layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}
}

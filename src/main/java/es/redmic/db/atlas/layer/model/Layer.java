package es.redmic.db.atlas.layer.model;

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
import java.util.HashSet;
import java.util.Set;

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

import org.hibernate.annotations.Type;

import es.redmic.databaselib.common.model.LongModel;

@Entity
@Table(name = "servicewms")
@NamedQuery(name = "Layer.findAll", query = "SELECT l FROM Layer l")
public class Layer extends LongModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String description;
	
	private String alias;
	
	private Boolean atlas;
	
	@OneToMany(mappedBy = "layer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Protocols> protocols = new HashSet<Protocols>();

	@Type(type = "es.redmic.db.common.type.DoubleArrayType")
	@Column(name="latlonboundsimage")
	private Double[] latLonBoundsImage;
	
	@Column(name="urlsource")
	private String urlSource;
	
	@Transient
	private String path;
	
	@ManyToOne
	@JoinColumn(name = "parentid")
	private Layer parent;
	
	@ManyToOne
	@JoinColumn(name = "themeinspireid")
	private ThemeInspire themeInspire;

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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Boolean getAtlas() {
		return atlas;
	}

	public void setAtlas(Boolean atlas) {
		this.atlas = atlas;
	}

	public Set<Protocols> getProtocols() {
		return protocols;
	}

	public void setProtocols(Set<Protocols> protocols) {
		
		this.protocols.clear();
		
		if (protocols == null)
			return;
			
		for (Protocols protocol : protocols)
			addProtocol(protocol);
	}

	public Protocols addProtocol(Protocols protocol) {
		
		protocol.setLayer(this);
		getProtocols().add(protocol);
		return protocol;
	}
	
	public void removeProtocol(Protocols protocol) {
		
		protocol.setLayer(null);
		getProtocols().remove(protocol);
	}

	public Double[] getLatLonBoundsImage() {
		return latLonBoundsImage;
	}

	public void setLatLonBoundsImage(Double[] latLonBoundsImage) {
		this.latLonBoundsImage = latLonBoundsImage;
	}

	public String getUrlSource() {
		return urlSource;
	}

	public void setUrlSource(String urlSource) {
		this.urlSource = urlSource;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Layer getParent() {
		return parent;
	}

	public void setParent(Layer parent) {
		this.parent = parent;
	}
	
	public ThemeInspire getThemeInspire() {
		return themeInspire;
	}

	public void setThemeInspire(ThemeInspire themeInspire) {
		this.themeInspire = themeInspire;
	}
}

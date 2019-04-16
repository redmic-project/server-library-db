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

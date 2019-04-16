package es.redmic.db.maintenance.administrative.model;

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
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.administrative.model.Platform;
import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the platformtype database table.
 * 
 */
@Entity
@Table(name = "platformtype")
@NamedQuery(name = "Platformtype.findAll", query = "SELECT p FROM PlatformType p")
public class PlatformType extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Platform
	@OneToMany(mappedBy = "platformtype")
	private Set<Platform> platforms;

	public PlatformType() {
	}

	public Set<Platform> getPlatforms() {
		return this.platforms;
	}

	public void setPlatforms(Set<Platform> platforms) {
		this.platforms = platforms;
	}

	public Platform addPlatform(Platform platform) {
		getPlatforms().add(platform);
		platform.setPlatformType(this);

		return platform;
	}

	public Platform removePlatform(Platform platform) {
		getPlatforms().remove(platform);
		platform.setPlatformType(null);

		return platform;
	}

}

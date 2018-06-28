package es.redmic.db.maintenance.administrative.model;

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
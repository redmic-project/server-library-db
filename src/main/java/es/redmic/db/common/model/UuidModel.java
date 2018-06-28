package es.redmic.db.common.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UuidModel extends UpdatableModel {

	public UuidModel() {
		super();
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = true)
	private UUID uuid;

	
	public String getUuid() {
		return uuid.toString();
	}

	public void setUuid(String uuid) {
		if (uuid != null)
			this.uuid = UUID.fromString(uuid);
	}
}

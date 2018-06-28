package es.redmic.db.geodata.common.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.common.model.UpdatableModel;

@MappedSuperclass
public class GeoDataModel extends UpdatableModel {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = true)
	private UUID uuid;
	
	// bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name = "activityid")
	private Activity activity;

	public String getUuid() {
		return uuid.toString();
	}

	public void setUuid(String uuid) {
		if (uuid != null)
			this.uuid = UUID.fromString(uuid);
	}
	
	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
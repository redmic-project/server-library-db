package es.redmic.db.geodata.common.model;

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

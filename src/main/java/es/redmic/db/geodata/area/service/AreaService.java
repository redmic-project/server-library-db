package es.redmic.db.geodata.area.service;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.area.model.Area;
import es.redmic.db.geodata.area.repository.AreaRepository;
import es.redmic.db.geodata.common.service.ServiceGeo;
import es.redmic.exception.database.DBNotFoundException;
import es.redmic.models.es.geojson.area.dto.AreaDTO;
import es.redmic.models.es.geojson.area.dto.AreaPropertiesDTO;

@Service
public class AreaService extends ServiceGeo<Area, AreaDTO> {

	AreaRepository repository;

	@Autowired
	public AreaService(AreaRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public Area findByUuid(UUID uuid) {
		return repository.findByUuid(uuid);
	}

	public AreaDTO updateProperties(AreaPropertiesDTO properties, String uuid) {

		Area area = findByUuid(UUID.fromString(uuid));

		if (area == null)
			throw new DBNotFoundException("uuid", uuid);

		AreaDTO areaDTO = new AreaDTO();
		areaDTO.setProperties(properties);

		Area model = convertDtoToModel(areaDTO);
		model.setUuid(uuid);
		model.setId(area.getId());

		model.setGeometry(area.getGeometry());
		AreaDTO result = convertModelToDto(this.updateModel(model));
		result.getProperties().setActivityId(model.getActivity().getId().toString());
		result.set_meta(areaDTO.get_meta());
		result = updateReferences(result, areaDTO, model);
		publish(UPDATE_EVENT, result);
		return result;
	}
}

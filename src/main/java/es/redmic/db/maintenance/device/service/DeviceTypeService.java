package es.redmic.db.maintenance.device.service;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.device.model.DeviceType;
import es.redmic.db.maintenance.device.repository.DeviceTypeRepository;
import es.redmic.models.es.maintenance.device.dto.DeviceTypeDTO;

@Service
public class DeviceTypeService extends
		ServiceDomain<DeviceType, DeviceTypeDTO> {

	@Autowired
	public DeviceTypeService(DeviceTypeRepository repository) {
		super(repository);
	}
}

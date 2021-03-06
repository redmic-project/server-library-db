package es.redmic.db.series.infrastructureattributes.service;

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

import es.redmic.db.geodata.infrastructure.service.InfrastructureService;
import es.redmic.db.series.common.service.SeriesService;
import es.redmic.db.series.infrastructureattributes.model.InfrastructureAttributes;
import es.redmic.db.series.infrastructureattributes.repository.InfrastructureAttributesRepository;
import es.redmic.models.es.series.attributeseries.dto.AttributeSeriesDTO;

@Service
public class InfrastructureAttributesService extends SeriesService<InfrastructureAttributes, AttributeSeriesDTO> {

	@Autowired
	InfrastructureService infrastructureService;

	@Autowired
	public InfrastructureAttributesService(InfrastructureAttributesRepository repository) {
		super(repository);
	}

	@Override
	protected InfrastructureAttributes setReferences(InfrastructureAttributes model, AttributeSeriesDTO dto) {

		model.setInfrastructure(infrastructureService.getByUuid(dto.get_parentId()));
		return model;
	}
}

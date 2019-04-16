package es.redmic.db.geodata.citation.service;

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

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Misidentification;
import es.redmic.db.geodata.citation.model.Citation;
import es.redmic.db.geodata.citation.repository.CitationRepository;
import es.redmic.db.geodata.common.service.ServiceGeo;
import es.redmic.models.es.geojson.citation.dto.CitationDTO;

@Service
public class CitationService extends ServiceGeo<Citation, CitationDTO> {
	
	CitationRepository repository;

	@Autowired
	public CitationService(CitationRepository repository) {
		super(repository);
		this.repository = repository;
	}
	
	public List<Citation> findByMisidentification(Misidentification misidentification) {
		return repository.findByMisidentification(misidentification);
	}
	
	public Citation findByUuid(UUID uuid) {
		return repository.findByUuid(uuid);
	}
}

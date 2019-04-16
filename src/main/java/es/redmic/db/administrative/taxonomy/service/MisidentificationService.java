package es.redmic.db.administrative.taxonomy.service;

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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Misidentification;
import es.redmic.db.administrative.taxonomy.model.Taxon;
import es.redmic.db.administrative.taxonomy.repository.MisidentificationRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.geodata.citation.model.Citation;
import es.redmic.db.geodata.citation.service.CitationService;
import es.redmic.models.es.administrative.taxonomy.dto.MisidentificationDTO;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;
import es.redmic.models.es.geojson.citation.dto.CitationDTO;

@Service
public class MisidentificationService extends ServiceRWImpl<Misidentification, MisidentificationDTO> { 
	
	@Autowired
	CitationService citationService;
	
	@Autowired
	public MisidentificationService(MisidentificationRepository repository) {
		super(repository);
	}
	
	@Override
	public MisidentificationDTO save(MisidentificationDTO dto) {
		
		Misidentification misIdent = this.saveModel(convertDtoToModel(dto));
		MisidentificationDTO result = convertModelToDto(misIdent);
		result.setCitations(dto.getCitations());
		
	
		List<String> citations = dto.getCitations();
		Taxon badIdentity = null;
		
		for (int i=0; i<citations.size(); i++) {
			Citation citation = citationService.findByUuid(UUID.fromString(citations.get(i)));
			citation.setMisidentification(misIdent);
			if (badIdentity == null) {
				result.setBadIdentity(factory.getMapperFacade().map(citation.getTaxon(), TaxonDTO.class));
				publish(ADD_EVENT, result);
			}
			CitationDTO citationDTO = citationService.convertModelToDto(citationService.updateModel(citation));
			citationDTO.getProperties().setActivityId(String.valueOf(citation.getActivity().getId()));
			citationService.publish(UPDATE_EVENT, citationDTO);
		}
		
		
		return result;
	}
	
	@Override
	public MisidentificationDTO update(MisidentificationDTO dto) {
		
		// Se localizan las citas con esta identificaci�n erronea
		Misidentification misidentification = findById(dto.getId());
		List<Citation> citations = citationService.findByMisidentification(misidentification);
		
		List<String> citationsNew = dto.getCitations();
		
		List<Long> citationsUpdated = new ArrayList<Long>();
		
		//Para todas aquellas que estaban antes y ahora no, se elimina el campo misidentification
		for (int i=0; i<citations.size(); i++) {
			Citation citation = citations.get(i);
			if (!citationsNew.contains(citation.getId())) {
				citation.setMisidentification(null);
				CitationDTO citationDTO = citationService.convertModelToDto(citationService.updateModel(citation));
				citationDTO.getProperties().setActivityId(String.valueOf(citation.getActivity().getId()));
				citationService.publish(UPDATE_EVENT, citationDTO);
			}
			else
				citationsUpdated.add(citation.getId());
		}
		
		Misidentification misIdent = this.updateModel(convertDtoToModel(dto));
		MisidentificationDTO result = convertModelToDto(misIdent);
		result.setCitations(dto.getCitations());
		
		// Save misidentificationid in new citations
		Taxon badIdentity = null;
		for (int i=0; i<citationsNew.size(); i++) {
			if (!citationsUpdated.contains(citationsNew.get(i))) {
				Citation citation = citationService.findByUuid(UUID.fromString(citationsNew.get(i)));
				if (badIdentity == null) {
					badIdentity = citation.getTaxon();
					result.setBadIdentity(factory.getMapperFacade().map(badIdentity, TaxonDTO.class));
					publish(UPDATE_EVENT, result);
				}
				citation.setMisidentification(misIdent);
				CitationDTO citationDTO = citationService.convertModelToDto(citationService.updateModel(citation));
				citationDTO.getProperties().setActivityId(String.valueOf(citation.getActivity().getId()));
				citationService.publish(UPDATE_EVENT, citationDTO);
			}
		}
		return result;
	}
	
	@Override
	public void delete(Long id) {
		Misidentification misidentification = findById(id);
		List<Citation> citations = citationService.findByMisidentification(misidentification);
		
		for (int i=0; i<citations.size(); i++) {
			Citation citation = citations.get(i);
			citation.setMisidentification(null);
			CitationDTO citationDTO = citationService.convertModelToDto(citationService.updateModel(citation));
			citationDTO.getProperties().setActivityId(String.valueOf(citation.getActivity().getId()));
			citationService.publish(UPDATE_EVENT, citationDTO);
		}
		
		super.delete(misidentification);
	}
}

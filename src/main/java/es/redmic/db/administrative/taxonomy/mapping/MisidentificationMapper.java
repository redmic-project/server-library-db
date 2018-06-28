package es.redmic.db.administrative.taxonomy.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.redmic.db.administrative.model.Document;
import es.redmic.db.administrative.taxonomy.model.Misidentification;
import es.redmic.db.administrative.taxonomy.model.Taxon;
import es.redmic.db.geodata.citation.model.Citation;
import es.redmic.db.geodata.citation.service.CitationService;
import es.redmic.models.es.administrative.dto.DocumentDTO;
import es.redmic.models.es.administrative.taxonomy.dto.MisidentificationDTO;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class MisidentificationMapper extends CustomMapper<Misidentification, MisidentificationDTO> {

	@Autowired
	CitationService citationService;
	
	@Override
	public void mapAtoB(Misidentification a, MisidentificationDTO b, MappingContext context) {
		
		b.setDocument(mapperFacade.map(b.getDocument(), DocumentDTO.class));
		b.setTaxon(mapperFacade.map(b.getTaxon(), TaxonDTO.class));
		
		List<Citation> citations = citationService.findByMisidentification(a);
		if (citations != null && citations.size() > 0)
			b.setBadIdentity(mapperFacade.map(citations.get(0).getTaxon(), TaxonDTO.class));
	}

	@Override
	public void mapBtoA(MisidentificationDTO b, Misidentification a, MappingContext context) {
		
		a.setDocument(mapperFacade.map(b.getDocument(), Document.class));
		a.setTaxon(mapperFacade.map(b.getTaxon(), Taxon.class));
	}
}

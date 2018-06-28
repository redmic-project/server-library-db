package es.redmic.db.geodata.citation.mapping;

import org.springframework.stereotype.Component;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.geodata.citation.model.Citation;
import es.redmic.models.es.geojson.citation.dto.CitationDTO;
import es.redmic.models.es.geojson.citation.dto.CitationPropertiesDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class CitationMapper extends CustomMapper<Citation, CitationDTO> {

	@Override
	public void mapAtoB(Citation a, CitationDTO b, MappingContext context) {
		CitationPropertiesDTO properties = mapperFacade.map(a, CitationPropertiesDTO.class);
		b.setGeometry(a.getGeometry());
		b.setProperties(properties);
		b.getProperties().setActivityId(a.getActivity().getId().toString());
		b.setId(a.getId());
		b.setUuid(a.getUuid());
	}

	@Override
	public void mapBtoA(CitationDTO b, Citation a, MappingContext context) {
		mapperFacade.map(b.getProperties(), a);

		if (a.getEndDate() == null && a.getStartDate() != null)
			a.setEndDate(a.getStartDate());

		a.setGeometry(b.getGeometry());
		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}
}
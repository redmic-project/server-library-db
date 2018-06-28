package es.redmic.db.geodata.toponym.mapper;

import org.springframework.stereotype.Component;

import es.redmic.db.geodata.toponym.model.Toponym;
import es.redmic.models.es.geojson.toponym.dto.ToponymDTO;
import es.redmic.models.es.geojson.toponym.dto.ToponymPropertiesDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class ToponymMapper extends CustomMapper<Toponym, ToponymDTO> {

	@Override
	public void mapAtoB(Toponym a, ToponymDTO b, MappingContext context) {
		ToponymPropertiesDTO properties = mapperFacade.map(a, ToponymPropertiesDTO.class);
		b.setGeometry(a.getGeometry());
		b.setProperties(properties);
		b.setId(a.getId());
	}

	@Override
	public void mapBtoA(ToponymDTO b, Toponym a, MappingContext context) {
		mapperFacade.map(b.getProperties(), a);
		a.setGeometry(b.getGeometry());
		a.setId(b.getId());
	}
}
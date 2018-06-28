package es.redmic.db.geodata.area.mapper;

import org.springframework.stereotype.Component;

import es.redmic.db.maintenance.areas.model.AreaClassification;
import es.redmic.db.maintenance.areas.model.ThematicType;
import es.redmic.models.es.maintenance.areas.dto.AreaClassificationDTO;
import es.redmic.models.es.maintenance.areas.dto.ThematicTypeBaseDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class AreaClassificationMapper extends CustomMapper<AreaClassification, AreaClassificationDTO> {

	@Override
	public void mapAtoB(AreaClassification a, AreaClassificationDTO b, MappingContext context) {

		b.setType(mapperFacade.map(a.getThematicType(), ThematicTypeBaseDTO.class));
	}

	@Override
	public void mapBtoA(AreaClassificationDTO b, AreaClassification a, MappingContext context) {

		a.setThematicType(mapperFacade.map(b.getType(), ThematicType.class));
	}
}
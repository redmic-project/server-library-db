package es.redmic.db.geodata.infrastructure.mapper;

import org.springframework.stereotype.Component;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.geodata.infrastructure.model.Infrastructure;
import es.redmic.db.maintenance.point.model.InfrastructureType;
import es.redmic.models.es.geojson.infrastructure.dto.InfrastructureDTO;
import es.redmic.models.es.geojson.infrastructure.dto.InfrastructurePropertiesDTO;
import es.redmic.models.es.maintenance.point.dto.InfrastructureTypeBaseDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class InfrastructureMapper extends CustomMapper<Infrastructure, InfrastructureDTO> {

	@Override
	public void mapAtoB(Infrastructure a, InfrastructureDTO b, MappingContext context) {

		InfrastructurePropertiesDTO properties = mapperFacade.map(a, InfrastructurePropertiesDTO.class);
		b.setGeometry(a.getGeometry());
		b.setProperties(properties);

		if (a.getInfrastructureType() != null)
			b.getProperties().setInfrastructureType(
					mapperFacade.map(a.getInfrastructureType(), InfrastructureTypeBaseDTO.class));

		b.getProperties().setActivityId(a.getActivity().getId().toString());
		b.setId(a.getId());
		b.setUuid(a.getUuid());
	}

	@Override
	public void mapBtoA(InfrastructureDTO b, Infrastructure a, MappingContext context) {

		mapperFacade.map(b.getProperties(), a);
		a.setGeometry(b.getGeometry());

		if (b.getProperties() != null && b.getProperties().getInfrastructureType() != null)
			a.setInfrastructureType(
					mapperFacade.map(b.getProperties().getInfrastructureType(), InfrastructureType.class));

		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}
}
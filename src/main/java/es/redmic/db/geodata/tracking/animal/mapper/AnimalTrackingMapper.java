package es.redmic.db.geodata.tracking.animal.mapper;

import org.springframework.stereotype.Component;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.geodata.tracking.animal.model.AnimalTracking;
import es.redmic.models.es.geojson.tracking.animal.dto.AnimalTrackingDTO;
import es.redmic.models.es.geojson.tracking.animal.dto.AnimalTrackingPropertiesDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class AnimalTrackingMapper extends CustomMapper<AnimalTracking, AnimalTrackingDTO> {

	@Override
	public void mapAtoB(AnimalTracking a, AnimalTrackingDTO b, MappingContext context) {
		AnimalTrackingPropertiesDTO properties = mapperFacade.map(a, AnimalTrackingPropertiesDTO.class);
		b.setGeometry(a.getGeometry());
		b.setProperties(properties);
		b.getProperties().setActivityId(a.getActivity().getId().toString());
		b.setId(a.getId());
		b.setUuid(a.getUuid());
	}

	@Override
	public void mapBtoA(AnimalTrackingDTO b, AnimalTracking a, MappingContext context) {
		mapperFacade.map(b.getProperties(), a);
		a.setGeometry(b.getGeometry());
		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}
}
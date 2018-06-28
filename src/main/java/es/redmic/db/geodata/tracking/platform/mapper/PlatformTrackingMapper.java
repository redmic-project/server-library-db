package es.redmic.db.geodata.tracking.platform.mapper;

import org.springframework.stereotype.Component;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.geodata.tracking.platform.model.PlatformTracking;
import es.redmic.models.es.geojson.tracking.platform.dto.PlatformTrackingDTO;
import es.redmic.models.es.geojson.tracking.platform.dto.PlatformTrackingPropertiesDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class PlatformTrackingMapper extends CustomMapper<PlatformTracking, PlatformTrackingDTO> {

	@Override
	public void mapAtoB(PlatformTracking a, PlatformTrackingDTO b, MappingContext context) {

		b.setGeometry(a.getGeometry());

		b.setId(a.getId());
		b.setUuid(a.getUuid());

		PlatformTrackingPropertiesDTO properties = mapperFacade.map(a, PlatformTrackingPropertiesDTO.class);
		b.setProperties(properties);
		b.getProperties().setActivityId(a.getActivity().getId().toString());
	}

	@Override
	public void mapBtoA(PlatformTrackingDTO b, PlatformTracking a, MappingContext context) {

		mapperFacade.map(b.getProperties(), a);
		a.setGeometry(b.getGeometry());
		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}

}

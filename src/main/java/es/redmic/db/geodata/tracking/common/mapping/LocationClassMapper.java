package es.redmic.db.geodata.tracking.common.mapping;

import org.springframework.stereotype.Component;

import es.redmic.db.geodata.tracking.common.model.LocationClass;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class LocationClassMapper extends CustomMapper<LocationClass, Character> {

	@Override
	public void mapAtoB(LocationClass a, Character b, MappingContext context) {
		
		if (a != null)
			b = a.getValue().charAt(0);;
	}

	@Override
	public void mapBtoA(Character b, LocationClass a, MappingContext context) {
		
		if (b != null)
			a = LocationClass.find(b.toString());
	}
}
package es.redmic.db.administrative.converter;

import org.springframework.stereotype.Component;

import es.redmic.db.administrative.model.Activity;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

@Component
public class ActivityIdConverter extends BidirectionalConverter<String, Activity> {

	@Override
	public Activity convertTo(String source, Type<Activity> destinationType) {
		Activity activityModel = new Activity();
		activityModel.setId(Long.valueOf(source));
		return activityModel;
	}

	@Override
	public String convertFrom(Activity source, Type<String> destinationType) {
		return source.getId().toString();
	}
}

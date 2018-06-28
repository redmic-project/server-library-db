package es.redmic.db.maintenance.quality.converter;

import org.springframework.stereotype.Component;

import es.redmic.db.maintenance.quality.model.VFlag;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

@Component
public class VFlagConverter extends BidirectionalConverter<VFlag, Character> {

	@Override
	public Character convertTo(VFlag source, Type<Character> destinationType) {
		return source.getId();
	}

	@Override
	public VFlag convertFrom(Character source, Type<VFlag> destinationType) {
		VFlag vFlag = new VFlag();
		vFlag.setId(source);
		return vFlag;
	}
}

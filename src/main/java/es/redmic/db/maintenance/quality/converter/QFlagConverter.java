package es.redmic.db.maintenance.quality.converter;

import org.springframework.stereotype.Component;

import es.redmic.db.maintenance.quality.model.QFlag;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

@Component
public class QFlagConverter extends BidirectionalConverter<QFlag, Character> {

	@Override
	public Character convertTo(QFlag source, Type<Character> destinationType) {
		return source.getId();
	}

	@Override
	public QFlag convertFrom(Character source, Type<QFlag> destinationType) {
		QFlag qFlag = new QFlag();
		qFlag.setId(source);
		return qFlag;
	}
}
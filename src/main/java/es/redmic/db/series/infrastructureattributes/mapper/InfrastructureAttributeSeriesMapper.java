package es.redmic.db.series.infrastructureattributes.mapper;

import org.springframework.stereotype.Component;

import es.redmic.db.series.common.mapper.SeriesBaseMapper;
import es.redmic.db.series.infrastructureattributes.model.InfrastructureAttributes;
import es.redmic.models.es.series.attributeseries.dto.AttributeSeriesDTO;
import ma.glasnost.orika.MappingContext;

@Component
public class InfrastructureAttributeSeriesMapper
		extends SeriesBaseMapper<InfrastructureAttributes, AttributeSeriesDTO> {

	@Override
	public void mapAtoB(InfrastructureAttributes a, AttributeSeriesDTO b, MappingContext context) {

		super.mapAtoB(a, b, context);
		b.set_grandparentId(a.getInfrastructure().getActivity().getId().toString());
		b.set_parentId(a.getInfrastructure().getUuid());
	}

	@Override
	public void mapBtoA(AttributeSeriesDTO b, InfrastructureAttributes a, MappingContext context) {
		super.mapBtoA(b, a, context);
	}
}
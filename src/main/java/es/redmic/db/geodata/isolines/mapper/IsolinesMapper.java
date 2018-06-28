package es.redmic.db.geodata.isolines.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.geodata.isolines.model.Isolines;
import es.redmic.db.maintenance.line.model.LineType;
import es.redmic.db.maintenance.parameter.model.DataDefinition;
import es.redmic.db.maintenance.parameter.repository.ParameterUnitRepository;
import es.redmic.models.es.geojson.isolines.dto.IsolinesDTO;
import es.redmic.models.es.geojson.isolines.dto.IsolinesPropertiesDTO;
import es.redmic.models.es.maintenance.line.dto.LineTypeBaseDTO;
import es.redmic.models.es.maintenance.parameter.dto.DataDefinitionDTO;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;
import es.redmic.models.es.series.common.dto.HierarchicalParameterDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class IsolinesMapper extends CustomMapper<Isolines, IsolinesDTO> {

	@Autowired
	ParameterUnitRepository parameterUnitRepository;

	@Override
	public void mapAtoB(Isolines a, IsolinesDTO b, MappingContext context) {

		IsolinesPropertiesDTO properties = mapperFacade.map(a, IsolinesPropertiesDTO.class);
		b.setGeometry(a.getGeometry());
		b.setProperties(properties);

		if (a.getLineType() != null) {
			b.getProperties().setLineType(mapperFacade.map(a.getLineType(), LineTypeBaseDTO.class));
		}

		HierarchicalParameterDTO parameterDTO = mapperFacade
				.map(a.getDataDefinition().getParameterUnit().getParameter(), HierarchicalParameterDTO.class);
		UnitDTO unitDto = mapperFacade.map(a.getDataDefinition().getParameterUnit().getUnit(), UnitDTO.class);

		b.getProperties().setParameter(parameterDTO);
		b.getProperties().setUnit(unitDto);
		b.getProperties().setDataDefinition(mapperFacade.map(a.getDataDefinition(), DataDefinitionDTO.class));
		b.getProperties().getDataDefinition().setZ(a.getZ());
		b.getProperties().setActivityId(a.getActivity().getId().toString());
		b.setId(a.getId());
		b.setUuid(a.getUuid());
	}

	@Override
	public void mapBtoA(IsolinesDTO b, Isolines a, MappingContext context) {

		mapperFacade.map(b.getProperties(), a);
		a.setGeometry(b.getGeometry());

		if (b.getProperties().getLineType() != null)
			a.setLineType(mapperFacade.map(b.getProperties().getLineType(), LineType.class));

		DataDefinition dataDefinition = mapperFacade.map(b.getProperties().getDataDefinition(), DataDefinition.class);
		dataDefinition.setParameterUnit(parameterUnitRepository
				.findByUnitAndParameter(b.getProperties().getParameter().getId(), b.getProperties().getUnit().getId()));
		a.setDataDefinition(dataDefinition);

		a.setActivity(mapperFacade.convert(b.getProperties().getActivityId(), Activity.class, null));
		a.setId(b.getId());
		a.setUuid(b.getUuid());
	}

}

package es.redmic.db.geodata.properties.fixedsurvey.mapper;

import org.springframework.stereotype.Component;

import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;
import es.redmic.models.es.series.common.dto.HierarchicalParameterDTO;
import es.redmic.models.es.series.common.dto.MeasurementDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class FixedMeasurementMapper extends CustomMapper<FixedMeasurement, MeasurementDTO> {
	
	@Override
	public void mapAtoB(FixedMeasurement a, MeasurementDTO b, MappingContext context) {
		HierarchicalParameterDTO parDto = 
				mapperFacade.map(a.getDataDefinition().getParameterUnit().getParameter(), HierarchicalParameterDTO.class);
		UnitDTO unitDto = 
				mapperFacade.map(a.getDataDefinition().getParameterUnit().getUnit(), UnitDTO.class);
		
		b.setParameter(parDto);
		b.setUnit(unitDto);
		b.getDataDefinition().setZ(a.getZ());
	}
}

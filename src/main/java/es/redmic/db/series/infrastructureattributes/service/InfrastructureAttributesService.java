package es.redmic.db.series.infrastructureattributes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.infrastructure.service.InfrastructureService;
import es.redmic.db.series.common.service.SeriesService;
import es.redmic.db.series.infrastructureattributes.model.InfrastructureAttributes;
import es.redmic.db.series.infrastructureattributes.repository.InfrastructureAttributesRepository;
import es.redmic.models.es.series.attributeseries.dto.AttributeSeriesDTO;

@Service
public class InfrastructureAttributesService extends SeriesService<InfrastructureAttributes, AttributeSeriesDTO> {

	@Autowired
	InfrastructureService infrastructureService;

	@Autowired
	public InfrastructureAttributesService(InfrastructureAttributesRepository repository) {
		super(repository);
	}

	@Override
	protected InfrastructureAttributes setReferences(InfrastructureAttributes model, AttributeSeriesDTO dto) {

		model.setInfrastructure(infrastructureService.getByUuid(dto.get_parentId()));
		return model;
	}
}

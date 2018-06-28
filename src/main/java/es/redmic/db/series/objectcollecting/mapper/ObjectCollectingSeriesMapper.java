package es.redmic.db.series.objectcollecting.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.redmic.db.geodata.common.domain.model.Confidence;
import es.redmic.db.geodata.common.domain.repository.ConfidenceRepository;
import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.db.geodata.properties.fixedsurvey.repository.FixedMeasurementRepository;
import es.redmic.db.maintenance.parameter.model.DataDefinition;
import es.redmic.db.series.common.mapper.SeriesBaseMapper;
import es.redmic.db.series.objectcollecting.model.ObjectCollecting;
import es.redmic.models.es.geojson.common.domain.dto.ConfidenceDTO;
import es.redmic.models.es.maintenance.objects.dto.ObjectClassificationDTO;
import es.redmic.models.es.series.objectcollecting.dto.ObjectCollectingSeriesDTO;
import ma.glasnost.orika.MappingContext;

@Component
public class ObjectCollectingSeriesMapper extends SeriesBaseMapper<ObjectCollecting, ObjectCollectingSeriesDTO> {

	@Autowired
	FixedMeasurementRepository measurementRepository;

	@Autowired
	ConfidenceRepository confidenceRepository;

	@Override
	public void mapAtoB(ObjectCollecting a, ObjectCollectingSeriesDTO b, MappingContext context) {

		super.mapAtoB(a, b, context);
		b.setDataDefinition(a.getFixedMeasurement().getDataDefinition().getId());

		if (a.getConfidence() != null)
			b.setConfidence(mapperFacade.map(a.getConfidence(), ConfidenceDTO.class));

		List<ObjectClassificationDTO> objects = new ArrayList<ObjectClassificationDTO>();
		for (int i = 0; i < a.getObjectCollectingClassification().size(); i++) {
			objects.add(mapperFacade.convert(a.getObjectCollectingClassification().get(i),
					ObjectClassificationDTO.class, null));
		}
		b.setObject(objects);

		b.set_grandparentId(a.getFixedMeasurement().getFixedSurvey().getActivity().getId().toString());
		b.set_parentId(a.getFixedMeasurement().getFixedSurvey().getUuid());
	}

	@Override
	public void mapBtoA(ObjectCollectingSeriesDTO b, ObjectCollecting a, MappingContext context) {

		super.mapBtoA(b, a, context);
		a.setFixedMeasurement(getMeasurement(b.getDataDefinition()));

		if (b.getConfidence() != null)
			a.setConfidence(getConfidence(b.getConfidence().getId()));
	}

	private Confidence getConfidence(Long confidenceId) {
		return confidenceRepository.findById(confidenceId).get();
	}

	private FixedMeasurement getMeasurement(Long dataDefinitionId) {

		DataDefinition dataDefinition = new DataDefinition();
		dataDefinition.setId(dataDefinitionId);

		return measurementRepository.findByDataDefinition(dataDefinition);
	}
}

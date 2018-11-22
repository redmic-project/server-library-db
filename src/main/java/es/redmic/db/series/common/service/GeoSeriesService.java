package es.redmic.db.series.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.redmic.db.geodata.common.repository.RepositoryGeo;
import es.redmic.db.geodata.common.service.ServiceGeo;
import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.db.geodata.properties.fixedsurvey.model.FixedSurvey;
import es.redmic.db.geodata.properties.fixedsurvey.repository.FixedMeasurementRepository;
import es.redmic.db.maintenance.parameter.model.DataDefinition;
import es.redmic.db.maintenance.parameter.model.ParameterUnit;
import es.redmic.db.maintenance.parameter.repository.ParameterUnitRepository;
import es.redmic.db.maintenance.parameter.service.DataDefinitionService;
import es.redmic.exception.database.DBNotFoundException;
import es.redmic.models.es.geojson.common.dto.FixedSurveySeriesPropertiesDTO;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;
import es.redmic.models.es.maintenance.parameter.dto.DataDefinitionDTO;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;
import es.redmic.models.es.series.common.dto.DataDefinitionSeriesDTO;
import es.redmic.models.es.series.common.dto.HierarchicalParameterDTO;
import es.redmic.models.es.series.common.dto.MeasurementDTO;

public abstract class GeoSeriesService<TModel extends FixedSurvey, TDTO extends MetaFeatureDTO<FixedSurveySeriesPropertiesDTO, ?>>
		extends ServiceGeo<TModel, TDTO> {

	@Autowired
	FixedMeasurementRepository fixedMeasurementRepository;

	@Autowired
	DataDefinitionService dataDefinitionService;

	@Autowired
	ParameterUnitRepository parameterUnitRepository;

	@Autowired
	public GeoSeriesService(RepositoryGeo<TModel, Long> repository) {
		super(repository);
	}

	@Override
	protected TDTO saveReferences(TDTO target, TDTO source, TModel model) {

		List<MeasurementDTO> measurementsResult = new ArrayList<MeasurementDTO>();

		List<MeasurementDTO> measurementsOrigin = source.getProperties().getMeasurements();

		for (int i = 0; i < measurementsOrigin.size(); i++) {

			MeasurementDTO measurementDTO = measurementsOrigin.get(i);

			// Guardamos dataDefinition
			DataDefinition dataDefinition = factory.getMapperFacade().map(measurementDTO.getDataDefinition(),
					DataDefinition.class);
			dataDefinition.setParameterUnit(
					getParameterUnit(measurementDTO.getParameter().getId(), measurementDTO.getUnit().getId()));
			dataDefinition = dataDefinitionService.saveModel(dataDefinition);

			// Guardamos measurement
			FixedMeasurement fixedMeasurement = new FixedMeasurement();
			fixedMeasurement.setFixedSurvey(model);
			fixedMeasurement.setZ(measurementDTO.getDataDefinition().getZ());
			fixedMeasurement.setDataDefinition(dataDefinition);
			fixedMeasurement = fixedMeasurementRepository.save(fixedMeasurement);

			// Construimos el dto de salida
			DataDefinitionSeriesDTO dataDefinitionItem = factory.getMapperFacade().map(dataDefinition,
					DataDefinitionSeriesDTO.class);
			dataDefinitionItem.setZ(fixedMeasurement.getZ());

			HierarchicalParameterDTO parDto = factory.getMapperFacade()
					.map(dataDefinition.getParameterUnit().getParameter(), HierarchicalParameterDTO.class);
			UnitDTO unitDto = factory.getMapperFacade().map(dataDefinition.getParameterUnit().getUnit(), UnitDTO.class);

			MeasurementDTO measurementItem = new MeasurementDTO();
			measurementItem.setDataDefinition(dataDefinitionItem);
			measurementItem.setParameter(parDto);
			measurementItem.setUnit(unitDto);
			measurementsResult.add(measurementItem);
		}

		target.getProperties().setMeasurements(measurementsResult);
		return target;
	}

	@Override
	protected TDTO updateReferences(TDTO target, TDTO source, TModel model) {

		List<MeasurementDTO> measurementsResult = new ArrayList<MeasurementDTO>();
		List<MeasurementDTO> measurementsOrigin = source.getProperties().getMeasurements();
		for (int i = 0; i < measurementsOrigin.size(); i++) {

			MeasurementDTO measurementDTO = measurementsOrigin.get(i);

			DataDefinitionDTO dataDefinitionDTO = measurementDTO.getDataDefinition();
			Double z = dataDefinitionDTO.getZ();
			// Guardamos measurement sin pasar por dto

			DataDefinition dataDefinition = factory.getMapperFacade().map(dataDefinitionDTO, DataDefinition.class);
			dataDefinition.setParameterUnit(
					getParameterUnit(measurementDTO.getParameter().getId(), measurementDTO.getUnit().getId()));

			FixedMeasurement fixedMeasurement = null;

			// Si data definition es null, el Measurement no existe y hay que insertarlo.
			if (dataDefinitionDTO.getId() == null) {

				dataDefinition = dataDefinitionService.saveModel(dataDefinition);

				fixedMeasurement = new FixedMeasurement();
				fixedMeasurement.setFixedSurvey(model);
				fixedMeasurement.setZ(z);
				fixedMeasurement.setDataDefinition(dataDefinition);
				fixedMeasurement = fixedMeasurementRepository.save(fixedMeasurement);
			} else {
				// Si el dataDefinition no es null, se espera que exista el Measurement sin
				// modificar la z
				fixedMeasurement = getFixedMeasurement(model.getId(), dataDefinitionDTO.getId(), z);
				// Si se ha modificado la z se debe modificar el fixedMeasurement
				if (fixedMeasurement == null) {
					fixedMeasurement = fixedMeasurementRepository.findByDataDefinitionId(dataDefinitionDTO.getId());
					fixedMeasurement.setZ(z);
					fixedMeasurement = fixedMeasurementRepository.save(fixedMeasurement);
				}
				dataDefinition = dataDefinitionService.updateModel(dataDefinition);
			}
			DataDefinitionSeriesDTO dataDefinitionItem = factory.getMapperFacade().map(dataDefinition,
					DataDefinitionSeriesDTO.class);
			dataDefinitionItem.setZ(fixedMeasurement.getZ());

			HierarchicalParameterDTO parDto = factory.getMapperFacade()
					.map(dataDefinition.getParameterUnit().getParameter(), HierarchicalParameterDTO.class);
			UnitDTO unitDto = factory.getMapperFacade().map(dataDefinition.getParameterUnit().getUnit(), UnitDTO.class);

			MeasurementDTO measurementItem = new MeasurementDTO();
			measurementItem.setDataDefinition(dataDefinitionItem);
			measurementItem.setParameter(parDto);
			measurementItem.setUnit(unitDto);
			measurementsResult.add(measurementItem);
		}
		// busca dataDefinition que no lleguen en la request y los elimina.
		deleteDataDefinitions(source.getProperties().getSite().getId(), measurementsResult);
		target.getProperties().setMeasurements(measurementsResult);
		return target;
	}

	private void deleteDataDefinitions(Long fixedSurveyId, List<MeasurementDTO> measurements) {

		List<FixedMeasurement> fixedMeasurements = fixedMeasurementRepository.findByFixedSurveyId(fixedSurveyId);

		for (int i = 0; i < fixedMeasurements.size(); i++) {

			boolean found = false;
			FixedMeasurement fixedMeasurement = fixedMeasurements.get(i);
			for (int j = 0; j < measurements.size(); j++) {
				if (measurements.get(j).getDataDefinition().getId().equals(fixedMeasurement.getId())) {
					found = true;
					break;
				}
			}
			if (found == false) {
				Long dataDefinitionId = fixedMeasurement.getId();
				fixedMeasurementRepository.delete(fixedMeasurement);
				dataDefinitionService.delete(dataDefinitionId);
			}
		}
	}

	private ParameterUnit getParameterUnit(Long parameterId, Long unitId) {
		ParameterUnit parameterUnit = parameterUnitRepository.findByUnitAndParameter(parameterId, unitId);

		if (parameterUnit == null)
			throw new DBNotFoundException("Relación parameter-unit", parameterId + "-" + unitId);

		return parameterUnit;
	}

	private FixedMeasurement getFixedMeasurement(Long surveySationId, Long dataDefinitionId, Double z) {
		return fixedMeasurementRepository.findByZAndSurveyStation(z, surveySationId, dataDefinitionId);
	}
}

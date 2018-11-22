package es.redmic.db.geodata.properties.fixedsurvey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.db.maintenance.parameter.model.DataDefinition;

public interface FixedMeasurementRepository extends BaseRepository<FixedMeasurement, Long> {

	@Query("select s from FixedMeasurement s where s.fixedSurvey.id = :id and s.z = :z and s.dataDefinition.id = :dataDefinitionId")
	FixedMeasurement findByZAndSurveyStation(@Param("z") double z, @Param("id") Long surveyStationId,
			@Param("dataDefinitionId") Long dataDefinitionId);

	@Query("select s from FixedMeasurement s where s.dataDefinition.id = :id")
	FixedMeasurement findByDataDefinitionId(@Param("id") Long dataDefinitionId);

	FixedMeasurement findByDataDefinition(DataDefinition dataDefinition);

	@Query("select s from FixedMeasurement s where s.fixedSurvey.id = :id")
	List<FixedMeasurement> findByFixedSurveyId(@Param("id") Long fixedSurveyId);
}

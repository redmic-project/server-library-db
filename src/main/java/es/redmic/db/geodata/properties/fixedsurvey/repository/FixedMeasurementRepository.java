package es.redmic.db.geodata.properties.fixedsurvey.repository;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

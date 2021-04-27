package es.redmic.db.series.infrastructureattributes.repository;

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


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.series.infrastructureattributes.model.InfrastructureAttributes;

public interface InfrastructureAttributesRepository extends BaseRepository<InfrastructureAttributes, Long> {

	@Query(value = "SELECT i FROM InfrastructureAttributes i WHERE i.id between :start and :end")
	Page<InfrastructureAttributes> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

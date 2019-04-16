package es.redmic.db.geodata.citation.repository;

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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.db.administrative.taxonomy.model.Misidentification;
import es.redmic.db.geodata.citation.model.Citation;
import es.redmic.db.geodata.common.repository.RepositoryGeo;

public interface CitationRepository extends RepositoryGeo<Citation, Long> {

	List<Citation> findByMisidentification(Misidentification misidentification);

	@Query(value = "SELECT c FROM Citation c WHERE c.id between :start and :end")
	Page<Citation> findBetween(@Param("start") long start, @Param("end") long end, Pageable pageable);
}

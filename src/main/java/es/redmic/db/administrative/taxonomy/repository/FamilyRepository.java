package es.redmic.db.administrative.taxonomy.repository;

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

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.administrative.taxonomy.model.Family;

public interface FamilyRepository extends BaseRepository<Family, Long> {
	
	@Query(value = "SELECT t FROM Family t WHERE t.validas IS NOT NULL")
	Page<Family> findFamilyWithValidAs(Pageable pageable);

}

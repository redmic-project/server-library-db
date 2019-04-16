package es.redmic.db.geodata.common.repository;

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

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.repository.NoRepositoryBean;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.geodata.common.model.GeoDataModel;

@NoRepositoryBean
public interface RepositoryGeo<TModel extends GeoDataModel, TKey extends Serializable> extends BaseRepository<TModel, TKey> {

	TModel findByUuid(UUID uuid);
}

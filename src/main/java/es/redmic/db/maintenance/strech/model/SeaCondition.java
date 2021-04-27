package es.redmic.db.maintenance.strech.model;

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

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the seacondition database table.
 * 
 */
@Entity
@Table(name="seacondition")
@NamedQuery(name="SeaCondition.findAll", query="SELECT s FROM SeaCondition s")
public class SeaCondition extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public SeaCondition() {
	}


}

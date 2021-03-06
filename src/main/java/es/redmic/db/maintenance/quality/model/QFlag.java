package es.redmic.db.maintenance.quality.model;

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

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the qflag database table.
 * 
 */
@Entity
@Table(name = "qflag")
@NamedQuery(name = "QFlag.findAll", query = "SELECT q FROM QFlag q")
public class QFlag extends FlagBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2704870371087499910L;

}

package es.redmic.db.maintenance.line.model;

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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.maintenance.common.model.ClassificationBase;


/**
 * The persistent class for the linetype database table.
 * 
 */
@Entity
@Table(name="linetype")
@NamedQuery(name="LineType.findAll", query="SELECT l FROM LineType l")
public class LineType extends ClassificationBase {
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 1500)
	private String remark;
	
	@ManyToOne
	@JoinColumn(name = "parentid")
	private LineType parent;
	
	public LineType() {
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LineType getParent() {
		return parent;
	}

	public void setParent(LineType parent) {
		this.parent = parent;
	}
}

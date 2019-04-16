package es.redmic.db.geodata.tracking.common.model;

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

public enum LocationClass {
	
	
	ARGOS_G("G"),
	ARGOS_3("3"),
	ARGOS_2("2"),
	ARGOS_1("1"),
	ARGOS_0("0"),
	ARGOS_A("A"),
	ARGOS_B("B"),
	ARGOS_Z("Z");
	
	private final String value;
	
	private LocationClass(final String newValue) {
		value = newValue;
	}
	
	public String getValue() { return value; }
	

	public static LocationClass find(String newValue) {
		for (LocationClass locationClass : LocationClass.values()) {
            if (locationClass.getValue() == newValue) return locationClass;
        }
		return null;  
	}
}

package es.redmic.db.geodata.common.service;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.config.EntityManagerWrapper;
import es.redmic.exception.common.ExceptionType;
import es.redmic.exception.common.InternalException;

/*
 * Servicio que devuelve la geometr�a y el gridid (Distribution) dado un x,y,radio y el tama�o del grid
 * 
 * */

@Service
public class GridService {

	@Autowired
	EntityManagerWrapper emw;

	public Map<String, Object> findGridByPointAndPrecision(Integer gridSize, Double x, Double y, Integer radius) { // ArrayList<Double>
																													// region,
																													// int[]
																													// taxons)
																													// {

		String queryString = "SELECT * from sde.getgridAsText(?, ?, ?, ?)";

		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(0, gridSize);
		parameters.add(1, x);
		parameters.add(2, y);
		parameters.add(3, radius);
		emw.setQueryString(queryString);
		emw.setParameters(parameters);

		ObjectMapper mapper = new ObjectMapper();

		List<String> result = emw.execute();

		if (result != null && result.get(0) != null) {
			try {
				return mapper.readValue(result.get(0), new TypeReference<Map<String, Object>>() {
				});
			} catch (IOException e) {
				throw new InternalException(ExceptionType.INTERNAL_EXCEPTION, e);
			}
		}
		return null;
	}
}

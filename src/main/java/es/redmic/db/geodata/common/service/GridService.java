package es.redmic.db.geodata.common.service;

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

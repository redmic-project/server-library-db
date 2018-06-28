package es.redmic.db.geodata.isolines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.common.service.ServiceGeo;
import es.redmic.db.geodata.isolines.model.Isolines;
import es.redmic.db.geodata.isolines.repository.IsolinesRepository;
import es.redmic.models.es.geojson.isolines.dto.IsolinesDTO;

@Service
public class IsolinesService extends ServiceGeo<Isolines, IsolinesDTO> {

	@Autowired
	public IsolinesService(IsolinesRepository repository) {
		super(repository);
	}
}

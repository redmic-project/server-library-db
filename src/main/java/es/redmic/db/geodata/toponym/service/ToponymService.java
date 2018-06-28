package es.redmic.db.geodata.toponym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.geodata.toponym.model.Toponym;
import es.redmic.db.geodata.toponym.repository.ToponymRepository;
import es.redmic.models.es.geojson.toponym.dto.ToponymDTO;

@Service
public class ToponymService extends ServiceRWImpl<Toponym, ToponymDTO> {

	@Autowired
	public ToponymService(ToponymRepository repository) {
		super(repository);
	}
}
package es.redmic.db.geodata.area.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.area.model.Area;
import es.redmic.db.geodata.area.repository.AreaRepository;
import es.redmic.db.geodata.common.service.ServiceGeo;
import es.redmic.exception.database.DBNotFoundException;
import es.redmic.models.es.geojson.area.dto.AreaDTO;
import es.redmic.models.es.geojson.area.dto.AreaPropertiesDTO;

@Service
public class AreaService extends ServiceGeo<Area, AreaDTO> {

	AreaRepository repository;

	@Autowired
	public AreaService(AreaRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public Area findByUuid(UUID uuid) {
		return repository.findByUuid(uuid);
	}

	public AreaDTO updateProperties(AreaPropertiesDTO properties, String uuid) {

		Area area = findByUuid(UUID.fromString(uuid));

		if (area == null)
			throw new DBNotFoundException("uuid", uuid);

		AreaDTO areaDTO = new AreaDTO();
		areaDTO.setProperties(properties);

		Area model = convertDtoToModel(areaDTO);
		model.setUuid(uuid);
		model.setId(area.getId());

		model.setGeometry(area.getGeometry());
		AreaDTO result = convertModelToDto(this.updateModel(model));
		result.getProperties().setActivityId(model.getActivity().getId().toString());
		result.set_meta(areaDTO.get_meta());
		result = updateReferences(result, areaDTO, model);
		publish(UPDATE_EVENT, result);
		return result;
	}
}
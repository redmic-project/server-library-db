package es.redmic.db.maintenance.line.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.line.model.LineType;
import es.redmic.db.maintenance.line.repository.LineTypeRepository;
import es.redmic.models.es.maintenance.line.dto.LineTypeDTO;

@Service
public class LineTypeService extends ServiceDomain<LineType, LineTypeDTO> {

	@Autowired
	public LineTypeService(LineTypeRepository repository) {
		super(repository);
	}
}

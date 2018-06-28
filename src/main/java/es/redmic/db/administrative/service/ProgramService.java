package es.redmic.db.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.model.Program;
import es.redmic.db.administrative.repository.ProgramRepository;
import es.redmic.models.es.administrative.dto.ProgramDTO;

@Service
public class ProgramService extends ActivityBaseService<Program, ProgramDTO> {

	@Autowired
	public ProgramService(ProgramRepository repository) {
		super(repository);
	}
}

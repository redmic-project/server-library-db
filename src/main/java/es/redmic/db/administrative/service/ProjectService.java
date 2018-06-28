package es.redmic.db.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.model.Project;
import es.redmic.db.administrative.repository.ProjectRepository;
import es.redmic.models.es.administrative.dto.ProjectDTO;

@Service
public class ProjectService extends ActivityBaseService<Project, ProjectDTO> {

	@Autowired
	public ProjectService(ProjectRepository repository) {
		super(repository);
	}
}

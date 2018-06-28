package es.redmic.db.maintenance.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.administrative.model.ProjectGroup;
import es.redmic.db.maintenance.administrative.repository.ProjectGroupRepository;
import es.redmic.models.es.maintenance.administrative.dto.ProjectGroupDTO;

@Service
public class ProjectGroupService extends
		ServiceDomain<ProjectGroup, ProjectGroupDTO> {

	@Autowired
	public ProjectGroupService(ProjectGroupRepository repository) {
		super(repository);
	}
}

package es.redmic.db.maintenance.strech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.strech.model.CensingStatus;
import es.redmic.db.maintenance.strech.repository.CensingStatusRepository;
import es.redmic.models.es.maintenance.strech.dto.CensingStatusDTO;

@Service
public class CensingStatusService extends
		ServiceDomain<CensingStatus, CensingStatusDTO> {

	@Autowired
	public CensingStatusService(CensingStatusRepository repository) {
		super(repository);
	}
}

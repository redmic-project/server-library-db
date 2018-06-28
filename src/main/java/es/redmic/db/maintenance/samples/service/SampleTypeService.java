package es.redmic.db.maintenance.samples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceDomain;
import es.redmic.db.maintenance.samples.model.SampleType;
import es.redmic.db.maintenance.samples.repository.SampleTypeRepository;
import es.redmic.models.es.maintenance.samples.dto.SampleTypeDTO;

@Service
public class SampleTypeService extends
		ServiceDomain<SampleType, SampleTypeDTO> {

	@Autowired
	public SampleTypeService(SampleTypeRepository repository) {
		super(repository);
	}
}

package es.redmic.db.maintenance.samples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.maintenance.samples.model.Sample;
import es.redmic.db.maintenance.samples.repository.SampleRepository;
import es.redmic.models.es.maintenance.samples.dto.SampleDTO;

@Service
public class SampleService extends ServiceRWImpl<Sample, SampleDTO> {

	@Autowired
	public SampleService(SampleRepository repository) {
		super(repository);
	}
}

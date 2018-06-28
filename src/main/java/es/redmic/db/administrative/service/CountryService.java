package es.redmic.db.administrative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.model.Country;
import es.redmic.db.administrative.repository.CountryRepository;
import es.redmic.db.common.service.ServiceDomain;
import es.redmic.models.es.maintenance.administrative.dto.CountryDTO;

@Service
public class CountryService extends ServiceDomain<Country, CountryDTO> {

	@Autowired
	public CountryService(CountryRepository repository) {
		super(repository);
	}
}

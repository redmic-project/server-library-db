package es.redmic.db.administrative.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Orderr;
import es.redmic.db.administrative.taxonomy.repository.OrderRepository;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;

@Service
public class OrderService extends TaxonAbstractService<Orderr, TaxonDTO> {

	@Autowired
	public OrderService(OrderRepository repository) {
		super(repository, 7L);
	}
}

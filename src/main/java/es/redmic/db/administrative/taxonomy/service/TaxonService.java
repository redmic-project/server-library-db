package es.redmic.db.administrative.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Classs;
import es.redmic.db.administrative.taxonomy.model.Family;
import es.redmic.db.administrative.taxonomy.model.Filum;
import es.redmic.db.administrative.taxonomy.model.Genus;
import es.redmic.db.administrative.taxonomy.model.Kingdom;
import es.redmic.db.administrative.taxonomy.model.Orderr;
import es.redmic.db.administrative.taxonomy.model.Species;
import es.redmic.db.administrative.taxonomy.model.Subfilum;
import es.redmic.db.administrative.taxonomy.model.Subspecies;
import es.redmic.db.administrative.taxonomy.model.Taxon;
import es.redmic.db.administrative.taxonomy.model.Variety;
import es.redmic.db.administrative.taxonomy.repository.TaxonRepository;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;

@Service
public class TaxonService extends TaxonAbstractService<Taxon, TaxonDTO> {

	@Autowired
	public TaxonService(TaxonRepository repository) {
		super(repository);
	}

	@Override
	public TaxonDTO update(TaxonDTO dto) {
		findById(dto.getId());

		Taxon model = (Taxon) factory.getMapperFacade().map(dto, getModelClassFromRank(dto.getRank().getId()));

		TaxonDTO result = convertModelToDto(updateModel(model));

		publish(UPDATE_EVENT, result);
		return result;
	}

	// TODO: buscar una forma dinámica de obtener la clase

	private Class<?> getModelClassFromRank(Long rainkId) {

		switch (rainkId.toString()) {
		case "1":
			return Kingdom.class;
		case "3":
			return Filum.class;
		case "5":
			return Subfilum.class;
		case "6":
			return Classs.class;
		case "7":
			return Orderr.class;
		case "8":
			return Family.class;
		case "9":
			return Genus.class;
		case "10":
			return Species.class;
		case "11":
			return Subspecies.class;
		case "12":
			return Variety.class;
		default:
			return Taxon.class;
		}
	}
}

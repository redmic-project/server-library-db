package es.redmic.db.administrative.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.AbstractSpecies;
import es.redmic.db.administrative.taxonomy.model.Species;
import es.redmic.db.administrative.taxonomy.model.Subspecies;
import es.redmic.db.administrative.taxonomy.model.Variety;
import es.redmic.db.administrative.taxonomy.repository.SpeciesRepository;
import es.redmic.db.maintenance.taxonomy.service.RankService;
import es.redmic.models.es.administrative.taxonomy.dto.SpeciesDTO;

@Service
public class SpeciesService extends TaxonAbstractService<AbstractSpecies, SpeciesDTO> {

	@Autowired
	RankService rankService;

	@Autowired
	public SpeciesService(SpeciesRepository repository) {
		super(repository);
	}

	@Override
	public SpeciesDTO save(SpeciesDTO dto) {
		AbstractSpecies model = convertDtoToModel(dto);
		model.setRank(rankService.convertDtoToModel(dto.getRank()));
		SpeciesDTO result = convertModelToDto(this.saveModel(convertToSpecificSpecies(model)));
		publish(ADD_EVENT, result);
		return result;
	}

	@Override
	public AbstractSpecies saveModel(AbstractSpecies model) {

		model.getProtection().setSpecies(model);
		return super.saveModel(model);
	}

	@Override
	public SpeciesDTO update(SpeciesDTO dto) {
		findById(dto.getId());
		AbstractSpecies model = convertDtoToModel(dto);
		model.setRank(rankService.convertDtoToModel(dto.getRank()));
		SpeciesDTO result = convertModelToDto(updateModel(convertToSpecificSpecies(model)));

		publish(UPDATE_EVENT, result);
		return result;
	}

	private AbstractSpecies convertToSpecificSpecies(AbstractSpecies model) {
		if (model.getRank() != null && model.getRank().getId() != null) {
			if (model.getRank().getId() == 10L) {
				model = (Species) factory.getMapperFacade().map(model, Species.class);
			} else if (model.getRank().getId() == 11L) {
				model = (Subspecies) factory.getMapperFacade().map(model, Subspecies.class);
			} else if (model.getRank().getId() == 12L) {
				model = (Variety) factory.getMapperFacade().map(model, Variety.class);
			}
		}
		return model;
	}
}

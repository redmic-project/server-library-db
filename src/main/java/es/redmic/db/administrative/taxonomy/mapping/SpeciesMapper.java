package es.redmic.db.administrative.taxonomy.mapping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.redmic.db.administrative.taxonomy.model.AbstractSpecies;
import es.redmic.db.administrative.taxonomy.model.Peculiarity;
import es.redmic.db.administrative.taxonomy.repository.ProtectionRepository;
import es.redmic.db.maintenance.taxonomy.model.Rank;
import es.redmic.models.es.administrative.taxonomy.dto.SpeciesDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class SpeciesMapper extends CustomMapper<AbstractSpecies, SpeciesDTO> {

	@Autowired
	ProtectionRepository protectionRepository;

	private static final Map<String, Long> index = new HashMap<>();
	static {
		p("kingdom", 1L);
		p("phylum", 3L);
		p("subphylum", 5L);
		p("class", 6L); // TODO: Hace falta repetirlo?
		p("classs", 6L);
		p("order", 7L); // TODO: Hace falta repetirlo?
		p("orderr", 7L);
		p("family", 8L);
		p("genus", 9L);
		p("species", 10L);
		p("subspecies", 11L);
		p("variety", 12L);
	}

	private static void p(String k, Long v) {
		index.put(k, v);
	}

	private static Long getCode(String key) {
		return index.get(key);
	}

	@Override
	public void mapAtoB(AbstractSpecies a, SpeciesDTO b, MappingContext context) {

		if (a.getProtection() != null)
			mapperFacade.map(a.getProtection(), b);

		// Hay que sobreescribir el id porque, en el mapper anterior se
		// sobreescribe por el de protection
		b.setId(a.getId());

		// Tipo de taxon
		// b.setRank(a.getRank().getId());
	}

	@Override
	public void mapBtoA(SpeciesDTO a, AbstractSpecies b, MappingContext context) {
		String nameClass = b.getClass().getSimpleName().toLowerCase();

		b.setProtection(mapperFacade.map(a, Peculiarity.class));

		if (a.getId() != null) {
			Peculiarity prot = protectionRepository.findOneByTaxon(a.getId());

			if (prot != null)
				b.getProtection().setId(prot.getId());
		}

		Rank rank = new Rank();
		rank.setId(getCode(nameClass));
		b.setRank(rank);

	}
}

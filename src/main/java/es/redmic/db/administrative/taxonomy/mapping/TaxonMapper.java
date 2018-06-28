package es.redmic.db.administrative.taxonomy.mapping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.redmic.db.administrative.taxonomy.model.Taxon;
import es.redmic.db.maintenance.taxonomy.model.Rank;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class TaxonMapper extends CustomMapper<Taxon, TaxonDTO> {

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
	public void mapAtoB(Taxon a, TaxonDTO b, MappingContext context) {
		// Tipo de taxon
		// if (a.getRank() != null)
		// b.setRank(a.getRank().getId());
	}

	@Override
	public void mapBtoA(TaxonDTO a, Taxon b, MappingContext context) {

		if (b.getRank() == null) {
			String nameClass = b.getClass().getSimpleName().toLowerCase();

			Rank rank = new Rank();
			rank.setId(getCode(nameClass));
			b.setRank(rank);
		}
	}
}

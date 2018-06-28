package es.redmic.db.administrative.taxonomy.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import es.redmic.db.geodata.citation.model.Citation;

@Entity
public class AbstractSpecies extends Taxon {

	public AbstractSpecies() {
		super();
	}
	
	private String groupicon;

	private String image;

	// bi-directional one-to-one association to Protection
	@OneToOne(mappedBy = "taxon", cascade = { CascadeType.ALL })
	private Peculiarity protection;

	@OneToMany(mappedBy = "taxon")
	private Set<Citation> citations;

	public String getGroupIcon() {
		return this.groupicon;
	}

	public void setGroupIcon(String groupicon) {
		this.groupicon = groupicon;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Peculiarity getProtection() {
		return this.protection;
	}

	public void setProtection(Peculiarity protection) {
		protection.setSpecies(this);
		this.protection = protection;
	}

	public Set<Citation> getCitations() {
		return this.citations;
	}

	public void setCitations(Set<Citation> citations) {
		this.citations = citations;
	}

	public Citation addCitation(Citation citation) {
		getCitations().add(citation);
		citation.setTaxon((Taxon) this);

		return citation;
	}

	public Citation removeCitation(Citation citation) {
		getCitations().remove(citation);
		citation.setTaxon(null);
		return citation;
	}

}

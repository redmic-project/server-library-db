package es.redmic.db.administrative.taxonomy.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.db.common.model.UuidModel;
import es.redmic.db.maintenance.animal.model.LifeStage;
import es.redmic.db.maintenance.animal.model.Sex;

/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name = "animal")
@NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a")
public class Animal extends UuidModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(length = 500)
	private String photo;

	@Column(length = 1000)
	private String description;

	@Column(length = 1000)
	private String note;

	// bi-directional many-to-one association to sex
	@ManyToOne
	@JoinColumn(name = "sexid")
	private Sex sex;

	// bi-directional many-to-one association to lifestage
	@ManyToOne
	@JoinColumn(name = "lifestageid")
	private LifeStage lifestage;

	// bi-directional many-to-one association to Taxon
	@ManyToOne
	@JoinColumn(name = "taxonid")
	private Taxon taxon;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime releasedate;

	@Column(length = 150)
	private String releaselocality;

	// bi-directional many-to-one association to Recovery
	@OneToMany(mappedBy = "animal", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<Recovery> recoveries;

	// bi-directional many-to-one association to Recovery
	@OneToMany(mappedBy = "animal", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<SpecimenTag> specimentags;

	public Animal() {
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Taxon getTaxon() {
		return taxon;
	}

	public void setTaxon(Taxon taxon) {
		this.taxon = taxon;
	}

	public DateTime getReleaseDate() {
		return releasedate;
	}

	public void setReleaseDate(DateTime releasedate) {
		this.releasedate = releasedate;
	}

	public String getReleaseLocality() {
		return releaselocality;
	}

	public void setReleaseLocality(String releaselocality) {
		this.releaselocality = releaselocality;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public LifeStage getLifeStage() {
		return lifestage;
	}

	public void setLifeStage(LifeStage lifestage) {
		this.lifestage = lifestage;
	}

	public Set<Recovery> getRecoveries() {
		return this.recoveries;
	}

	public void setRecoveries(Set<Recovery> recoveries) {
		this.recoveries = recoveries;
	}

	public Recovery addRecoveries(Recovery recoveries) {
		getRecoveries().add(recoveries);
		recoveries.setAnimal(this);

		return recoveries;
	}

	public Recovery removeRecoveries(Recovery recoveries) {
		getRecoveries().remove(recoveries);
		recoveries.setAnimal(null);

		return recoveries;
	}

	public Set<SpecimenTag> getSpecimenTags() {
		return this.specimentags;
	}

	public void setSpecimenTags(Set<SpecimenTag> specimentags) {
		this.specimentags = specimentags;
	}

	public SpecimenTag addSpecimenTags(SpecimenTag specimentags) {
		getSpecimenTags().add(specimentags);
		specimentags.setAnimal(this);

		return specimentags;
	}

	public SpecimenTag removeSpecimenTags(SpecimenTag specimentags) {
		getSpecimenTags().remove(recoveries);
		specimentags.setAnimal(null);

		return specimentags;
	}
}
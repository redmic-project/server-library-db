package es.redmic.db.administrative.taxonomy.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DiscriminatorOptions;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.db.common.model.UpdatableModel;
import es.redmic.db.maintenance.taxonomy.model.Rank;
import es.redmic.db.maintenance.taxonomy.model.Status;

@Entity
@Table(name = "taxon")
@NamedQuery(name = "Taxon.findAll", query = "SELECT t FROM Taxon t")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rankid", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorOptions(insert = false)
public class Taxon extends UpdatableModel {

	private Integer aphia;

	private String scientificname;

	private String authorship;

	private String commonname;

	private String worms;

	private String note;

	// bi-directional many-to-one association to Rank
	@ManyToOne
	@JoinColumn(name = "rankid", insertable = true, updatable = true)
	private Rank rank;

	// bi-directional many-to-one association to Taxon
	@ManyToOne
	@JoinColumn(name = "parentid")
	private Taxon parent;

	@Transient
	private String path;

	// bi-directional many-to-one association to Taxon
	@ManyToOne
	@JoinColumn(name = "validas")
	private Taxon validas;

	// bi-directional many-to-one association to Taxon
	@ManyToOne
	@JoinColumn(name = "statusid")
	private Status status;

	// bi-directional many-to-one association to Taxon
	@OneToMany(mappedBy = "taxon")
	private Set<Misidentification> misidentifications;

	@Column(name = "wormsupdated")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime wormsupdated;

	public Taxon() {
		super();
	}

	public Integer getAphia() {
		return this.aphia;
	}

	public void setAphia(Integer aphia) {
		this.aphia = aphia;
	}

	public String getAuthorship() {
		return this.authorship;
	}

	public void setAuthorship(String authorship) {
		this.authorship = authorship;
	}

	public String getCommonName() {
		return this.commonname;
	}

	public void setCommonName(String commonname) {
		this.commonname = commonname;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getScientificName() {
		return this.scientificname;
	}

	public void setScientificName(String scientificname) {
		this.scientificname = scientificname;
	}

	public String getWorms() {
		return this.worms;
	}

	public void setWorms(String worms) {
		this.worms = worms;
	}

	public Rank getRank() {
		return this.rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Taxon getParent() {
		return this.parent;
	}

	public void setParent(Taxon parent) {
		this.parent = parent;
	}

	public Taxon getValidAs() {
		return validas;
	}

	public void setValidAs(Taxon validAs) {
		this.validas = validAs;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Misidentification> getMisidentifications() {
		return this.misidentifications;
	}

	public void setMisidentifications(Set<Misidentification> misidentifications) {
		this.misidentifications = misidentifications;
	}

	public Misidentification addMisidentifications(Misidentification misidentifications) {
		getMisidentifications().add(misidentifications);
		misidentifications.setTaxon(this);

		return misidentifications;
	}

	public Misidentification removeMisidentifications(Misidentification misidentifications) {
		getMisidentifications().remove(misidentifications);
		misidentifications.setTaxon(null);

		return misidentifications;
	}

	public DateTime getWormsUpdated() {
		return wormsupdated;
	}

	public void setWormsUpdated(DateTime wormsupdated) {
		this.wormsupdated = wormsupdated;
	}
}
package es.redmic.db.maintenance.parameter.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import es.redmic.databaselib.common.model.LongModel;

/**
 * The persistent class for the unit database table.
 * 
 */
@Entity
@NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u")
public class Unit extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String acronym;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 50, nullable = false)
	private String name_en;

	// bi-directional many-to-one association to Parametertype
	@ManyToOne
	@JoinColumn(name = "unittypeid")
	private UnitType unittype;

	// bi-directional many-to-one association to Device
	@OneToMany(mappedBy = "unit")
	private List<ParameterUnit> parameterunits;

	public Unit() {
	}

	public String getAcronym() {
		return this.acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_en() {
		return this.name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public UnitType getUnitType() {
		return unittype;
	}

	public void setUnitType(UnitType unittype) {
		this.unittype = unittype;
	}

	public List<ParameterUnit> getParameterUnits() {
		return parameterunits;
	}

	public void setParameterUnits(List<ParameterUnit> parameterunits) {
		this.parameterunits = parameterunits;
	}

	public ParameterUnit addParameterunit(ParameterUnit parameterunit) {
		getParameterUnits().add(parameterunit);
		parameterunit.setUnit(this);

		return parameterunit;
	}

	public ParameterUnit removeParameterunit(ParameterUnit parameterunit) {
		getParameterUnits().remove(parameterunit);
		parameterunit.setUnit(null);

		return parameterunit;
	}
}
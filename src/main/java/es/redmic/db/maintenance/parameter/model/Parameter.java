package es.redmic.db.maintenance.parameter.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import es.redmic.db.common.model.DomainModel;

/**
 * The persistent class for the parameter database table.
 * 
 */
@Entity
@NamedQuery(name = "Parameter.findAll", query = "SELECT p FROM Parameter p")
public class Parameter extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String acronym;

	// bi-directional many-to-one association to Parametertype
	@ManyToOne
	@JoinColumn(name = "parametertypeid", nullable = false)
	private ParameterType parametertype;
	
	// bi-directional many-to-one association to ParameterUnit
	@OneToMany(mappedBy = "parameter", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ParameterUnit> units = new HashSet<ParameterUnit>();

	public Parameter() {
	}

	public String getAcronym() {
		return this.acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public ParameterType getParameterType() {
		return this.parametertype;
	}

	public void setParameterType(ParameterType parametertype) {
		this.parametertype = parametertype;
	}
	
	
	public Set<ParameterUnit> getUnits() {
		return units;
	}

	public void setUnits(Set<ParameterUnit> parameterunits) {
		
		this.units.clear();
		
		if (parameterunits == null)
			return;
		for (ParameterUnit parameterUnit : parameterunits)
			addParameterUnit(parameterUnit);
	}

	public ParameterUnit addParameterUnit(ParameterUnit parameterunit) {
		parameterunit.setParameter(this);
		getUnits().add(parameterunit);
		return parameterunit;
	}
}
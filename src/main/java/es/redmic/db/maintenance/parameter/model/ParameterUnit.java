package es.redmic.db.maintenance.parameter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;


/**
 * The persistent class for the parameterunit database table.
 * 
 */
@Entity
@Table(name="parameterunit")
@NamedQuery(name="ParameterUnit.findAll", query="SELECT p FROM ParameterUnit p")
public class ParameterUnit extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name = "parameterid", nullable = false)
	private Parameter parameter;
	
	// bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name = "unitid", nullable = false)
	private Unit unit;
	
	public ParameterUnit() {
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
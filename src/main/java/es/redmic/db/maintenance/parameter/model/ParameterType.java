package es.redmic.db.maintenance.parameter.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the parametertype database table.
 * 
 */
@Entity
@Table(name="parametertype")
@NamedQuery(name="ParameterType.findAll", query="SELECT p FROM ParameterType p")
public class ParameterType extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to Parameter
	@OneToMany(mappedBy="parametertype")
	private List<Parameter> parameters;

	public ParameterType() {
	}

	public List<Parameter> getParameters() {
		return this.parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public Parameter addParameter(Parameter parameter) {
		getParameters().add(parameter);
		parameter.setParameterType(this);

		return parameter;
	}

	public Parameter removeParameter(Parameter parameter) {
		getParameters().remove(parameter);
		parameter.setParameterType(null);

		return parameter;
	}

}
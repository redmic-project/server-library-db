package es.redmic.db.series.infrastructureattributes.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.geodata.infrastructure.model.Infrastructure;
import es.redmic.db.maintenance.qualifiers.model.Attributes;

@Entity
@Table(name="infrastructureattributes")
@NamedQuery(name="InfrastructureAttributes.findAll", query="SELECT i FROM InfrastructureAttributes i")
public class InfrastructureAttributes extends Attributes {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="infrastructurepointid", nullable = false)
	private Infrastructure infrastructure;
	
	public Infrastructure getInfrastructure() {
		return infrastructure;
	}

	public void setInfrastructure(Infrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}
}

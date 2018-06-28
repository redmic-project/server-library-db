package es.redmic.db.maintenance.parameter.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the unittype database table.
 * 
 */
@Entity
@Table(name="unittype")
@NamedQuery(name="UnitType.findAll", query="SELECT u FROM UnitType u")
public class UnitType extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to Unit
	@OneToMany(mappedBy="unittype")
	private List<Unit> units;
	
	public UnitType() {
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	
	public Unit addUnit(Unit unit) {
		getUnits().add(unit);
		unit.setUnitType(this);

		return unit;
	}

	public Unit removeUnit(Unit unit) {
		getUnits().remove(unit);
		unit.setUnitType(null);

		return unit;
	}

}
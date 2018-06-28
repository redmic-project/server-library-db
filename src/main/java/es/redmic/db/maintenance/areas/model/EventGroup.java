package es.redmic.db.maintenance.areas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the eventGroup database table.
 * 
 */
@Entity
@Table(name="eventgroup")
@NamedQuery(name="EventGroup.findAll", query="SELECT e FROM EventGroup e")
public class EventGroup extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public EventGroup() {
	}

}
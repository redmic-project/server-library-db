package es.redmic.db.maintenance.animal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the lifestage database table.
 * 
 */
@Entity
@Table(name="lifestage")
@NamedQuery(name="LifeStage.findAll", query="SELECT l FROM LifeStage l")
public class LifeStage extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public LifeStage() {
	}

}
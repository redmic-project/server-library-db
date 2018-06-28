package es.redmic.db.series.objectcollecting.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.maintenance.objects.model.ObjectType;

/**
 * The persistent class for the timeseries database table.
 * 
 */
@Entity
@Table(name="objectcollectingclassification")
@NamedQuery(name="ObjectCollectingClassification.findAll", query="SELECT o FROM ObjectCollectingClassification o")
public class ObjectCollectingClassification extends LongModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="objectcollectingid", nullable = false)
	private ObjectCollecting objectCollecting;
	
	@ManyToOne
	@JoinColumn(name="objecttypeid", nullable = false)
	private ObjectType objectType;
	
	public ObjectCollecting getObjectCollecting() {
		return objectCollecting;
	}

	public void setObjectCollecting(ObjectCollecting objectCollecting) {
		this.objectCollecting = objectCollecting;
	}

	public ObjectType getObjectType() {
		return objectType;
	}

	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}
}
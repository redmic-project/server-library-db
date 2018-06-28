package es.redmic.db.maintenance.objects.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.db.maintenance.common.model.ClassificationBase;

@Entity
@Table(name="objecttype")
@NamedQuery(name="ObjectType.findAll", query="SELECT o FROM ObjectType o")
public class ObjectType extends ClassificationBase implements Serializable {
	
	private static final long serialVersionUID = 1534534234L;
	
	@ManyToOne
	@JoinColumn(name = "parentid")
	private ObjectType parent;

	
	public ObjectType getParent() {
		return this.parent;
	}

	public void setParent(ObjectType parent) {
		this.parent = parent;
	}
}
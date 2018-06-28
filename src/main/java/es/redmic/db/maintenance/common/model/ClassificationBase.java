package es.redmic.db.maintenance.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.db.administrative.model.Document;
import es.redmic.db.common.model.DomainModel;

@MappedSuperclass
public abstract class ClassificationBase  extends DomainModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1345213543245345L;

	@Column(length = 50)
	private String code;
	
	@Column(name = "path")
	private String path;
	
	@Column(length = 1500)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "documentid")
	private Document document;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime inserted;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime updated;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document documentid) {
		this.document = documentid;
	}
	
	public DateTime getInserted() {
		return inserted;
	}

	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}
}
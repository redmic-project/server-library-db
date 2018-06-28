package es.redmic.db.administrative.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.redmic.databaselib.common.model.LongModel;

/**
 * The persistent class for the activitydocument database table.
 * 
 */
@Entity
@Table(name = "activitydocument")
@NamedQuery(name = "ActivityDocument.findAll", query = "SELECT a FROM ActivityDocument a")
public class ActivityDocument extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name = "activityid", nullable = false)
	private ActivityBase activity;

	// bi-directional many-to-one association to Document
	@ManyToOne
	@JoinColumn(name = "documentid", nullable = false)
	private Document document;

	public ActivityDocument() {
	}

	public ActivityBase getActivity() {
		return this.activity;
	}

	public void setActivity(ActivityBase activityBase) {
		this.activity = activityBase;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
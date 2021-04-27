package es.redmic.db.administrative.model;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.db.administrative.taxonomy.model.Misidentification;
import es.redmic.db.administrative.taxonomy.model.Peculiarity;
import es.redmic.db.common.model.UpdatableModel;
import es.redmic.db.maintenance.administrative.model.DocumentType;
import es.redmic.db.maintenance.device.model.Device;

/**
 * The persistent class for the document database table.
 * 
 */
@Entity
@Table(name = "document")
@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
public class Document extends UpdatableModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String code;

	@Column(nullable = false, length = 50)
	private String author;

	@Column(length = 50)
	private String remark;

	@Type(type = "es.redmic.db.common.type.StringArrayType")
	private String[] keywords;

	@Column(nullable = false, length = 50)
	private String source;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(nullable = false, length = 2)
	private String language;

	@Column(length = 250)
	private String url;

	@Column(nullable = false)
	private Integer year;

	@Column(name = "inserted")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime inserted;

	@ManyToOne
	@JoinColumn(name = "documenttypeid", nullable = false)
	private DocumentType documenttype;

	@OneToMany(mappedBy = "document")
	private Set<Embargo> embargos;

	@OneToMany(mappedBy = "document")
	private Set<Device> device;

	@OneToMany(mappedBy = "canarycatalogue")
	private List<Peculiarity> canarycatalogue;

	@OneToMany(mappedBy = "spaincatalogue")
	private List<Peculiarity> spaincatalogue;

	@OneToMany(mappedBy = "eudirective")
	private List<Peculiarity> eudirective;

	@OneToMany(mappedBy = "document")
	private Set<Misidentification> misidentifications;

	public Document() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<String> getKeywords() {
		Set<String> output = null;
		if (keywords != null && keywords.length > 0)
			output = new HashSet<String>(Arrays.asList(keywords));

		return output;
	}

	public void setKeywords(Set<String> keywords) {
		if (keywords != null && !keywords.isEmpty())
			this.keywords = keywords.toArray(new String[keywords.size()]);
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public DateTime getInserted() {
		return inserted;
	}

	@Override
	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}

	public DocumentType getDocumentType() {
		return this.documenttype;
	}

	public void setDocumentType(DocumentType documenttype) {
		this.documenttype = documenttype;
	}

	public Set<Embargo> getEmbargos() {
		return this.embargos;
	}

	public void setEmbargos(Set<Embargo> embargos) {
		this.embargos = embargos;
	}

	public Embargo addEmbargo(Embargo embargo) {
		getEmbargos().add(embargo);
		embargo.setDocument(this);

		return embargo;
	}

	public Embargo removeEmbargo(Embargo embargo) {
		getEmbargos().remove(embargo);
		embargo.setDocument(null);

		return embargo;
	}

	public List<Peculiarity> getCanaryCatalogue() {
		return this.canarycatalogue;
	}

	public void setCanaryCatalogue(List<Peculiarity> canarycatalogue) {
		this.canarycatalogue = canarycatalogue;
	}

	public Peculiarity addCanaryCatalogue(Peculiarity canarycatalogue) {
		getCanaryCatalogue().add(canarycatalogue);
		canarycatalogue.setCanaryCatalogue(this);

		return canarycatalogue;
	}

	public Peculiarity removecanarycatalogue(Peculiarity canarycatalogue) {
		getCanaryCatalogue().remove(canarycatalogue);
		canarycatalogue.setCanaryCatalogue(null);

		return canarycatalogue;
	}

	public List<Peculiarity> getSpainCatalogue() {
		return this.spaincatalogue;
	}

	public void setSpainCatalogue(List<Peculiarity> spaincatalogue) {
		this.spaincatalogue = spaincatalogue;
	}

	public Peculiarity addSpainCatalogue(Peculiarity spaincatalogue) {
		getSpainCatalogue().add(spaincatalogue);
		spaincatalogue.setSpainCatalogue(this);

		return spaincatalogue;
	}

	public Peculiarity removeSpainCatalogue(Peculiarity spaincatalogue) {
		getSpainCatalogue().remove(spaincatalogue);
		spaincatalogue.setSpainCatalogue(null);

		return spaincatalogue;
	}

	public List<Peculiarity> getEUDirective() {
		return this.eudirective;
	}

	public void setEUDirective(List<Peculiarity> eudirective) {
		this.eudirective = eudirective;
	}

	public Peculiarity addEUDirective(Peculiarity eudirective) {
		getEUDirective().add(eudirective);
		eudirective.setEuDirective(this);

		return eudirective;
	}

	public Peculiarity removeEUDirective(Peculiarity eudirective) {
		getEUDirective().remove(eudirective);
		eudirective.setEuDirective(null);

		return eudirective;
	}

	public Set<Device> getDevice() {
		return device;
	}

	public void setDevice(Set<Device> device) {
		this.device = device;
	}

	public Set<Misidentification> getMisidentifications() {
		return this.misidentifications;
	}

	public void setMisidentifications(Set<Misidentification> misidentifications) {
		this.misidentifications = misidentifications;
	}

	public Misidentification addMisidentifications(Misidentification misidentifications) {
		getMisidentifications().add(misidentifications);
		misidentifications.setDocument(this);

		return misidentifications;
	}

	public Misidentification removeMisidentifications(Misidentification misidentifications) {
		getMisidentifications().remove(misidentifications);
		misidentifications.setDocument(null);

		return misidentifications;
	}

}

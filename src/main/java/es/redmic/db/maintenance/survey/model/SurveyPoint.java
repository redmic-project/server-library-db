package es.redmic.db.maintenance.survey.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.databaselib.common.model.LongModel;


/**
 * The persistent class for the surveypoint database table.
 * 
 */
@Entity
@Table(name="surveypoint")
@NamedQuery(name="SurveyPoint.findAll", query="SELECT s FROM SurveyPoint s")
public class SurveyPoint extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String code;

	@Column(name = "date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime date;

	private double seadepth;

	public SurveyPoint() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DateTime getDate() {
		return this.date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public double getSeadepth() {
		return this.seadepth;
	}

	public void setSeadepth(double seadepth) {
		this.seadepth = seadepth;
	}
}
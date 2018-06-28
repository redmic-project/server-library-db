package es.redmic.db.maintenance.samples.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.redmic.db.common.model.DomainModel;


/**
 * The persistent class for the sampletype database table.
 * 
 */
@Entity
@Table(name="sampletype")
@NamedQuery(name="SampleType.findAll", query="SELECT s FROM SampleType s")
public class SampleType extends DomainModel implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="sampletype")
	private List<Sample> samples;

	public SampleType() {
	}

	public List<Sample> getSamples() {
		return this.samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}

	public Sample addSample(Sample sample) {
		getSamples().add(sample);
		sample.setSampletype(this);

		return sample;
	}

	public Sample removeSample(Sample sample) {
		getSamples().remove(sample);
		sample.setSampletype(null);

		return sample;
	}

}
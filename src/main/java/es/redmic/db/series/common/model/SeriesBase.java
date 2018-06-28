package es.redmic.db.series.common.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import es.redmic.databaselib.common.model.LongModel;
import es.redmic.db.maintenance.quality.model.QFlag;
import es.redmic.db.maintenance.quality.model.VFlag;

@MappedSuperclass
public abstract class SeriesBase extends LongModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "qflagid")
	private QFlag qFlag;

	@ManyToOne
	@JoinColumn(name = "vflagid")
	private VFlag vFlag;

	public QFlag getQFlag() {
		return this.qFlag;
	}

	public void setQFlag(QFlag qFlag) {
		this.qFlag = qFlag;
	}

	public VFlag getVFlag() {
		return this.vFlag;
	}

	public void setVFlag(VFlag vFlag) {
		this.vFlag = vFlag;
	}
}
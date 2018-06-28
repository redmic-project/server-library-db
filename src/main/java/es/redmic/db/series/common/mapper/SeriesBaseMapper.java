package es.redmic.db.series.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import es.redmic.db.maintenance.quality.model.QFlag;
import es.redmic.db.maintenance.quality.model.VFlag;
import es.redmic.db.maintenance.quality.repository.QFlagRepository;
import es.redmic.db.maintenance.quality.repository.VFlagRepository;
import es.redmic.db.series.common.model.SeriesBase;
import es.redmic.exception.database.DBNotFoundException;
import es.redmic.models.es.series.common.dto.SeriesCommonDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public abstract class SeriesBaseMapper<TModel extends SeriesBase, TDTO extends SeriesCommonDTO>
		extends CustomMapper<TModel, TDTO> {

	@Autowired
	QFlagRepository qFlagRepository;

	@Autowired
	VFlagRepository vFlagRepository;

	@Override
	public void mapAtoB(SeriesBase a, SeriesCommonDTO b, MappingContext context) {

		b.setQFlag(a.getQFlag().getId());
		b.setVFlag(a.getVFlag().getId());
	}

	@Override
	public void mapBtoA(SeriesCommonDTO a, SeriesBase b, MappingContext context) {

		b.setQFlag(getQFlag(a.getQFlag()));
		b.setVFlag(getVFlag(a.getVFlag()));
	}

	private QFlag getQFlag(Character qFlagId) {

		QFlag qFlag = qFlagRepository.findById(qFlagId).get();
		if (qFlag == null)
			throw new DBNotFoundException("qFlag", qFlagId.toString());
		return qFlag;
	}

	private VFlag getVFlag(Character vFlagId) {
		VFlag vFlag = vFlagRepository.findById(vFlagId).get();
		if (vFlag == null)
			throw new DBNotFoundException("vFlag", vFlagId.toString());
		return vFlag;
	}
}

package es.redmic.db.atlas.layer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.atlas.layer.model.ThemeInspire;
import es.redmic.db.atlas.layer.repository.ThemeInspireRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.models.es.atlas.dto.ThemeInspireDTO;

@Service
public class ThemeInspireService extends ServiceRWImpl<ThemeInspire, ThemeInspireDTO> {

	@Autowired
	public ThemeInspireService(ThemeInspireRepository repository) {
		super(repository);
	}
}

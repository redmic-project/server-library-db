package es.redmic.db.administrative.taxonomy.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import es.redmic.db.administrative.taxonomy.model.Animal;
import es.redmic.db.administrative.taxonomy.model.Recovery;
import es.redmic.db.administrative.taxonomy.model.SpecimenTag;
import es.redmic.db.administrative.taxonomy.repository.AnimalRepository;
import es.redmic.db.administrative.taxonomy.repository.RecoveryRepository;
import es.redmic.db.administrative.taxonomy.repository.SpecimenTagRepository;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.exception.database.DBConstraintViolationException;
import es.redmic.exception.database.DBPropertyValueException;
import es.redmic.models.es.administrative.taxonomy.dto.AnimalDTO;
import es.redmic.models.es.administrative.taxonomy.dto.RecoveryDTO;
import es.redmic.models.es.administrative.taxonomy.dto.SpecimenTagDTO;

@Service
public class AnimalService extends ServiceRWImpl<Animal, AnimalDTO> {

	@Autowired
	RecoveryRepository repositoryRecovery;

	@Autowired
	SpecimenTagRepository repositorySpecimenTag;

	@Autowired
	public AnimalService(AnimalRepository repository) {
		super(repository);
	}

	@Override
	public AnimalDTO save(AnimalDTO dto) {

		List<RecoveryDTO> recoveries = dto.getRecoveries();
		dto.setRecoveries(null);

		List<SpecimenTagDTO> specimenTags = dto.getSpecimenTags();
		dto.setSpecimenTags(null);

		Animal model = convertDtoToModel(dto);
		model = super.saveModel(model);
		saveRecoveries(dto, model, recoveries);
		saveSpecimenTags(dto, model, specimenTags);

		AnimalDTO result = convertModelToDto(model);
		publish(ADD_EVENT, result);
		return result;
	}

	public AnimalDTO update(AnimalDTO dto) {

		List<RecoveryDTO> recoveries = dto.getRecoveries();
		dto.setRecoveries(null);

		List<SpecimenTagDTO> specimenTags = dto.getSpecimenTags();
		dto.setSpecimenTags(null);

		findById(dto.getId());
		Animal model = convertDtoToModel(dto);
		model = super.updateModel(model);

		updateRecoveries(dto, model, recoveries);
		updateSpecimenTags(dto, model, specimenTags);

		AnimalDTO result = convertModelToDto(model);

		publish(UPDATE_EVENT, result);
		return result;
	}

	public void saveRecoveries(AnimalDTO a, Animal b, List<RecoveryDTO> recoveries) {
		Set<Recovery> setRecovery = new HashSet<Recovery>();
		
		if (recoveries != null) {
			for (int i = 0; i < recoveries.size(); i++) {
				Recovery recovery = new Recovery();
				recovery = factory.getMapperFacade().map(recoveries.get(i), Recovery.class);
	
				recovery.setAnimal(b);
	
				try {
					repositoryRecovery.save(recovery);
				} catch (DataIntegrityViolationException e) {
					throw new DBConstraintViolationException(e);
				} catch (ConstraintViolationException e) {
					throw new DBPropertyValueException(e);
				}
				setRecovery.add(recovery);
			}
		}
		b.setRecoveries(setRecovery);
	}

	public void updateRecoveries(AnimalDTO a, Animal b, List<RecoveryDTO> recoveries) {
		Set<Recovery> setRecovery = new HashSet<Recovery>();
		List<Recovery> listRecoveries = new ArrayList<Recovery>();

		try {
			listRecoveries = repositoryRecovery.findByAnimal(b);
		} catch (DataIntegrityViolationException e) {
			throw new DBConstraintViolationException(e);
		} catch (ConstraintViolationException e) {
			throw new DBPropertyValueException(e);
		}

		if (recoveries != null) {
			for (int i = 0; i < recoveries.size(); i++) {
				Recovery recovery = new Recovery();
				recovery = factory.getMapperFacade().map(recoveries.get(i), Recovery.class);
	
				recovery.setAnimal(b);
	
				Boolean exists = false;
	
				for (int n = 0; n < listRecoveries.size(); n++) {
					if (listRecoveries.get(n).getId() == recovery.getId()) {
						exists = true;
						listRecoveries.remove(n);
						break;
					}
				}
	
				try {
					if (!exists)
						repositoryRecovery.save(recovery);
				} catch (DataIntegrityViolationException e) {
					throw new DBConstraintViolationException(e);
				} catch (ConstraintViolationException e) {
					throw new DBPropertyValueException(e);
				}
				setRecovery.add(recovery);
			}
		}
		for (int n = 0; n < listRecoveries.size(); n++) {
			try {
				repositoryRecovery.delete(listRecoveries.get(n));
			} catch (DataIntegrityViolationException e) {
				throw new DBConstraintViolationException(e);
			} catch (ConstraintViolationException e) {
				throw new DBPropertyValueException(e);
			}
		}

		b.setRecoveries(setRecovery);
	}

	public void saveSpecimenTags(AnimalDTO a, Animal b, List<SpecimenTagDTO> specimenTags) {
		Set<SpecimenTag> setSpecimenTag = new HashSet<SpecimenTag>();

		if (specimenTags != null) {
			for (int i = 0; i < specimenTags.size(); i++) {
				SpecimenTag specimenTag = new SpecimenTag();
				specimenTag = factory.getMapperFacade().map(specimenTags.get(i), SpecimenTag.class);
	
				specimenTag.setAnimal(b);
	
				try {
					repositorySpecimenTag.save(specimenTag);
				} catch (DataIntegrityViolationException e) {
					throw new DBConstraintViolationException(e);
				} catch (ConstraintViolationException e) {
					throw new DBPropertyValueException(e);
				}
				setSpecimenTag.add(specimenTag);
			}
		}
		b.setSpecimenTags(setSpecimenTag);
	}

	public void updateSpecimenTags(AnimalDTO a, Animal b, List<SpecimenTagDTO> specimenTags) {
		Set<SpecimenTag> setSpecimenTag = new HashSet<SpecimenTag>();
		List<SpecimenTag> listSpecimenTag = new ArrayList<SpecimenTag>();

		try {
			listSpecimenTag = repositorySpecimenTag.findByAnimal(b);
		} catch (DataIntegrityViolationException e) {
			throw new DBConstraintViolationException(e);
		} catch (ConstraintViolationException e) {
			throw new DBPropertyValueException(e);
		}

		if (specimenTags != null) {
			for (int i = 0; i < specimenTags.size(); i++) {
				SpecimenTag specimenTag = new SpecimenTag();
				specimenTag = factory.getMapperFacade().map(specimenTags.get(i), SpecimenTag.class);
	
				specimenTag.setAnimal(b);
	
				Boolean exists = false;
	
				for (int n = 0; n < listSpecimenTag.size(); n++) {
					if (listSpecimenTag.get(n).getId() == specimenTag.getId()) {
						exists = true;
						listSpecimenTag.remove(n);
						break;
					}
				}
	
				try {
					if (!exists)
						repositorySpecimenTag.save(specimenTag);
				} catch (DataIntegrityViolationException e) {
					throw new DBConstraintViolationException(e);
				} catch (ConstraintViolationException e) {
					throw new DBPropertyValueException(e);
				}
				setSpecimenTag.add(specimenTag);
			}
		}
		for (int n = 0; n < listSpecimenTag.size(); n++) {
			try {
				repositorySpecimenTag.delete(listSpecimenTag.get(n));
			} catch (DataIntegrityViolationException e) {
				throw new DBConstraintViolationException(e);
			} catch (ConstraintViolationException e) {
				throw new DBPropertyValueException(e);
			}
		}

		b.setSpecimenTags(setSpecimenTag);
	}

}
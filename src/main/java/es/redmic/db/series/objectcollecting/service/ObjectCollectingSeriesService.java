package es.redmic.db.series.objectcollecting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.redmic.db.geodata.properties.fixedsurvey.model.FixedMeasurement;
import es.redmic.db.maintenance.objects.model.ObjectType;
import es.redmic.db.series.common.service.RWBaseSeriesService;
import es.redmic.db.series.objectcollecting.model.ObjectCollecting;
import es.redmic.db.series.objectcollecting.model.ObjectCollectingClassification;
import es.redmic.db.series.objectcollecting.repository.ObjectCollectingClassificationRepository;
import es.redmic.db.series.objectcollecting.repository.ObjectCollectingRepository;
import es.redmic.models.es.maintenance.objects.dto.ObjectClassificationDTO;
import es.redmic.models.es.maintenance.objects.dto.ObjectCollectingDTO;
import es.redmic.models.es.series.objectcollecting.dto.ObjectCollectingSeriesDTO;

@Service
public class ObjectCollectingSeriesService extends RWBaseSeriesService<ObjectCollecting, ObjectCollectingSeriesDTO> {
	
	@Autowired
	ObjectCollectingClassificationRepository objectCollectingClassificationRepository;

	ObjectCollectingRepository repository;

	@Autowired
	public ObjectCollectingSeriesService(ObjectCollectingRepository repository) {
		super(repository);
		this.repository = repository;
	}
	
	private List<ObjectCollectingClassification> getClassification(ObjectCollectingSeriesDTO a, ObjectCollecting b) {
			
		List<ObjectClassificationDTO> classificationListDTO = a.getObject();
		
		if (classificationListDTO == null && a.getId() != null)
			return findById(a.getId()).getObjectCollectingClassification();
		
		// Guardamos las clasificaciones
		List<ObjectCollectingClassification> setObjectCollectingClassification = new
				ArrayList<ObjectCollectingClassification>();
		int numOfClassifications = classificationListDTO.size();
		for (int i=0; i<numOfClassifications; i++) {
			List<ObjectCollectingDTO> classification = classificationListDTO.get(i).getClassification();
			ObjectType objClass = null;
			Long objectCollectingClassificationId = classificationListDTO.get(i).getId();
			// Si solo tiene una classificación, se guarda esa
			if (classification.size() == 1) {
				objClass = factory.getMapperFacade().map(classification.get(0).getObjectType(), ObjectType.class);
			} else if (classification.size() > 1) { //si no, se busca la más específica
				int pathLength = 1;
				for (int j=0; j<classification.size(); j++) {
					if (classification.get(j).getObjectType().getPath().split("\\.").length > pathLength) { // La classificación más específica es la de path con longitud mayor
						pathLength = classification.get(j).getObjectType().getPath().split("\\.").length;
						objClass = factory.getMapperFacade().map(classification.get(j).getObjectType(), ObjectType.class);
					}
				}
			}
			// Guardamos la clasificación
			ObjectCollectingClassification objectCollectingClassification = new ObjectCollectingClassification();
			objectCollectingClassification.setId(objectCollectingClassificationId);
			objectCollectingClassification.setObjectCollecting(b);
			objectCollectingClassification.setObjectType(objClass);

			setObjectCollectingClassification.add(objectCollectingClassification);			
		}
		return setObjectCollectingClassification;
	}

	@Override
	protected ObjectCollecting setFixedMeasurement(ObjectCollecting model, FixedMeasurement stationMeasurement) {
		
		model.setFixedMeasurement(stationMeasurement);
		return model;
	}

	@Override
	protected ObjectCollecting setReferences(ObjectCollecting model, ObjectCollectingSeriesDTO dto) {
		
		model.setObjectCollectingClassification(getClassification(dto, model));
		return model;
	}
}
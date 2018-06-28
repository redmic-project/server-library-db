package es.redmic.db.series.objectcollecting.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.redmic.db.maintenance.objects.model.ObjectType;
import es.redmic.db.maintenance.objects.repository.ObjectTypeRepository;
import es.redmic.db.series.objectcollecting.model.ObjectCollectingClassification;
import es.redmic.db.series.objectcollecting.repository.ObjectCollectingClassificationRepository;
import es.redmic.models.es.maintenance.objects.dto.ObjectClassificationDTO;
import es.redmic.models.es.maintenance.objects.dto.ObjectCollectingDTO;
import es.redmic.models.es.maintenance.objects.dto.ObjectTypeBaseDTO;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

@Component
public class ObjectCollectingClassificationConverter
		extends BidirectionalConverter<ObjectCollectingClassification, ObjectClassificationDTO> {

	@Autowired
	ObjectTypeRepository repository;

	ObjectCollectingClassificationRepository objectCollectingClassificationRepository;

	@Override
	public ObjectClassificationDTO convertTo(ObjectCollectingClassification source,
			Type<ObjectClassificationDTO> destinationType) {
		ObjectClassificationDTO result = new ObjectClassificationDTO();// mapperFacade.map(source.getObjectType().getObjectGroup(),
																		// ObjectClassificationDTO.class);
		result.setId(source.getId());
		List<ObjectCollectingDTO> classification = new ArrayList<ObjectCollectingDTO>();

		// Guardamos el más específico
		classification.add(getObjectDTO(source.getObjectType(), 1));
		// Guardamos los ancestors
		String[] pathSplitted = source.getObjectType().getPath().split("\\."),
				ancestorsIds = Arrays.copyOfRange(pathSplitted, 1, pathSplitted.length - 1);

		for (int i = 0; i < ancestorsIds.length; i++) {
			classification.add(getObjectDTO(repository.findById(Long.parseLong(ancestorsIds[i])).get(), 2));
		}
		result.setClassification(classification);

		return result;
	}

	@Override
	public ObjectCollectingClassification convertFrom(ObjectClassificationDTO source,
			Type<ObjectCollectingClassification> destinationType) {
		return new ObjectCollectingClassification();
	}

	private ObjectCollectingDTO getObjectDTO(ObjectType obj, Integer level) {

		ObjectCollectingDTO objectCollectingDTO = new ObjectCollectingDTO();
		ObjectTypeBaseDTO item = mapperFacade.map(obj, ObjectTypeBaseDTO.class);
		item.setLevel(level);

		objectCollectingDTO.setObjectType(item);

		return objectCollectingDTO;
	}
}
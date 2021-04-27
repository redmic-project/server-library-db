package es.redmic.db.series.objectcollecting.converter;

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

package es.redmic.db.geodata.common.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.administrative.service.ActivityService;
import es.redmic.db.common.service.ServiceRWImpl;
import es.redmic.db.geodata.common.model.GeoDataModel;
import es.redmic.db.geodata.common.repository.RepositoryGeo;
import es.redmic.exception.common.ExceptionType;
import es.redmic.exception.common.InternalException;
import es.redmic.exception.databinding.DataTypeNotValidException;
import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;

public abstract class ServiceGeo<TModel extends GeoDataModel, TDTO extends MetaFeatureDTO<?, ?>>
		extends ServiceRWImpl<TModel, TDTO> {

	RepositoryGeo<TModel, Long> repository;

	@Autowired
	ActivityService activityService;

	public ServiceGeo(RepositoryGeo<TModel, Long> repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public TDTO save(TDTO dto) {
		TModel model = convertDtoToModel(dto);
		TDTO result = convertModelToDto(this.saveModel(model));
		result.getProperties().setActivityId(model.getActivity().getId().toString());
		result = saveReferences(result, dto, model);
		publish(ADD_EVENT, result);
		return result;
	}

	@Override
	public TDTO update(TDTO dto) {
		findById(dto.getId());
		TModel model = convertDtoToModel(dto);
		TDTO result = convertModelToDto(this.updateModel(model));
		result.getProperties().setActivityId(model.getActivity().getId().toString());
		result.set_meta(dto.get_meta());
		result = updateReferences(result, dto, model);
		publish(UPDATE_EVENT, result);
		return result;
	}

	public void delete(String uuid) {

		delete(repository.findByUuid(UUID.fromString(uuid)));
	}

	public TModel getByUuid(String uuid) {

		return repository.findByUuid(UUID.fromString(uuid));
	}

	@Override
	public void delete(Long id) {
		throw new InternalException(ExceptionType.INTERNAL_EXCEPTION);
	}

	/*
	 * Función para comprobar si el tipo de dato corresponde con el tipo de
	 * actividad con la que se va a asociar En caso de que la actividad no tenga
	 * asignada una categoría, se le añade la que representa el dato.
	 */
	public void checkDataType(String activityId) {

		String activityCategoryExpected = DataPrefixType.getPrefixTypeFromClass(typeOfTDTO);

		Activity activity = activityService.findById(Long.parseLong(activityId));

		checkActivityCategory(activity.getActivityCategory(), activityCategoryExpected);

		List<Long> activityTypeIdsExpected = DataPrefixType.getActivityTypesFromClass(typeOfTDTO);

		checkActivityTypeId(activity.getActivityType().getId(), activityTypeIdsExpected);

		// Si no tiene category asignada, se añade
		if (activity.getActivityCategory() == null) {
			saveActivityCategory(activity, activityCategoryExpected);
		}
	}

	private void checkActivityCategory(String activityCategory, String activityCategoryExpected) {

		if (activityCategory != null && !activityCategory.equals(activityCategoryExpected)) {
			LOGGER.debug("Esperada category " + activityCategoryExpected + " sin embargo la actividad tiene asignada "
					+ activityCategory);
			throw new DataTypeNotValidException();
		}
	}

	private void checkActivityTypeId(Long activityTypeId, List<Long> activityTypeIdsExpected) {

		if (!activityTypeIdsExpected.contains(activityTypeId)) {

			LOGGER.debug("Esperados activityTypes ids " + activityTypeIdsExpected
					+ " sin embargo la actividad tiene asignada " + activityTypeId);
			throw new DataTypeNotValidException();

		}
	}

	private void saveActivityCategory(Activity activity, String activityCategoryExpected) {

		activity.setActivityCategory(activityCategoryExpected);
		activityService.update(activityService.convertModelToDto(activity));
	}

	/*
	 * Función que debe estar definida en los servicios específicos. Se usa para
	 * guardar datos de otros modelos que llegan en el dto
	 * 
	 * @param target DTO relleno parcialmente a falta de completar las
	 * referencias
	 * 
	 * @param source DTO enviado a guardar obtener las referencias.
	 * 
	 * @param model Modelo a guardar, necesario para añadir las referencias
	 * 
	 * @return DTO recibido con las referencias añadidas.
	 */
	protected TDTO saveReferences(TDTO target, TDTO source, TModel model) {
		return target;
	}

	/*
	 * Función que debe estar definida en los servicios específicos. Se usa para
	 * modificar datos de otros modelos que llegan en el dto
	 *
	 * @param target DTO relleno parcialmente a falta de completar las
	 * referencias
	 * 
	 * @param source DTO enviado a guardar obtener las referencias.
	 * 
	 * @param model Modelo a guardar, necesario para añadir las referencias.
	 * 
	 * @return DTO recibido con las referencias añadidas.
	 */
	protected TDTO updateReferences(TDTO target, TDTO source, TModel model) {
		return target;
	}
}

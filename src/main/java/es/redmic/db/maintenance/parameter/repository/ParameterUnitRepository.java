package es.redmic.db.maintenance.parameter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.redmic.databaselib.common.repository.BaseRepository;
import es.redmic.db.maintenance.parameter.model.Parameter;
import es.redmic.db.maintenance.parameter.model.ParameterUnit;

public interface ParameterUnitRepository extends BaseRepository<ParameterUnit, Long> {
	List<ParameterUnit> findByParameter(Parameter parameter);

	@Query("select pu from ParameterUnit pu where pu.parameter.id = :parameterId and pu.unit.id = :unitId")
	ParameterUnit findByUnitAndParameter(@Param("parameterId") Long parameterId, @Param("unitId") Long unitId);
}
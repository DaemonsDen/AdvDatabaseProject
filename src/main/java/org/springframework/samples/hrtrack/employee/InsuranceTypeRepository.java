package org.springframework.samples.hrtrack.employee;

import java.util.Collection;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface InsuranceTypeRepository extends CrudRepository<InsuranceType, Integer> {

	Collection<InsuranceType> findAll() throws DataAccessException;

	Collection<InsuranceType> findByInsurancetype(int inId) throws DataAccessException;

}

package org.springframework.samples.hrtrack.employee;

import java.util.Collection;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DependentRepository extends CrudRepository<Dependent, Integer> {

	Collection<Dependent> findAll() throws DataAccessException;

}

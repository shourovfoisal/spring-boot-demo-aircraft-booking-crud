package com.shourovfoisal.assesment.dao.aircraft;

import com.shourovfoisal.assesment.entity.aircraft.Aircraft;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftDAO extends CrudRepository<Aircraft, Integer> {
}

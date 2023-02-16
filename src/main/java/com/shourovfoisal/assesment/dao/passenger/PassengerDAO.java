package com.shourovfoisal.assesment.dao.passenger;

import com.shourovfoisal.assesment.entity.passenger.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDAO extends CrudRepository<Passenger, Integer> {
}

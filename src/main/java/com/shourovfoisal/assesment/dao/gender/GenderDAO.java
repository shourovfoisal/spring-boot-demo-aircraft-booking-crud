package com.shourovfoisal.assesment.dao.gender;

import com.shourovfoisal.assesment.entity.gender.Gender;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderDAO extends CrudRepository<Gender, Integer> {
}

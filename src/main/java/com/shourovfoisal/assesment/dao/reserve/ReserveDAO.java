package com.shourovfoisal.assesment.dao.reserve;

import com.shourovfoisal.assesment.entity.reserve.Reserve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveDAO extends CrudRepository<Reserve, Integer> {
}

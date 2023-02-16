package com.shourovfoisal.assesment.service.reserve;

import com.shourovfoisal.assesment.dao.reserve.ReserveDAO;
import com.shourovfoisal.assesment.dto.reserve.ReserveDTO;
import com.shourovfoisal.assesment.entity.reserve.Reserve;
import com.shourovfoisal.assesment.mapper.reserve.ReserveRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReserveService {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private ReserveDAO reserveDAO;

    public Reserve createReserve(Reserve payload) {
        payload.setCreatedTime(LocalDateTime.now());
        return reserveDAO.save(payload);
    }

    public List<ReserveDTO> getReserveList(String query, Object[] parameters, int[] argTypes) {
        return this.template.query(query, parameters, argTypes, new ReserveRowMapper());
    }

    public Reserve updateReserve(Reserve reserve) {
        reserve.setUpdatedTime(LocalDateTime.now());
        return reserveDAO.save(reserve);
    }

    public void deleteReserve(Reserve reserve) {
        reserveDAO.delete(reserve);
    }
}

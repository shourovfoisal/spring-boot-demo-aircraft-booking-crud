package com.shourovfoisal.assesment.component;

import org.springframework.stereotype.Component;

@Component
public class QueryBuilder {

    public String getQueryParamOfAircraft(String conditions) {
        String query = "SELECT * FROM aircraft a \n" +
                       "LEFT JOIN aircraft_type at ON a.aircraft_type_id=at.id \n"+
                       "WHERE 1" + conditions;
        return query;
    }

}

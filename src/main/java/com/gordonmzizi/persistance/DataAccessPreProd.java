package com.gordonmzizi.persistance;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DataAccessPreProd extends DataAccessSuper {
    @Value("${preprod}")
    private String preprod;


    public DataAccessPreProd(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate,dataSource);

    }




}

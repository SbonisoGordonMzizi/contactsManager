package com.gordonmzizi.persistance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DataAccessProd  extends DataAccessSuper {
    @Value("${prod}")
    private String prod;
    private DataSource dataSource;


    public DataAccessProd(DataSource dataSource,JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        this.dataSource = dataSource;
    }


}

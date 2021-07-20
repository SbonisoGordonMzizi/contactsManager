package com.gordonmzizi.persistance;


import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;

public class DataAccessPreProd implements DataAccess{
    @Value("${preprod}")
    private String preprod;
    private DataSource dataSource;

    public DataAccessPreProd(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void hello() {
        System.out.println("Pre-Production DATA "+this.preprod);
    }
}

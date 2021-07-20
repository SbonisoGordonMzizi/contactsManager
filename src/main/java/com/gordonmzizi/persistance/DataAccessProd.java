package com.gordonmzizi.persistance;

import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;

public class DataAccessProd implements DataAccess {
    @Value("${prod}")
    private String prod;
    private DataSource dataSource;

    public DataAccessProd(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void hello(){

        System.out.println("Production DATA "+prod);
    }
}

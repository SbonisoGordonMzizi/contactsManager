package com.gordonmzizi.persistance;

import org.springframework.beans.factory.annotation.Value;

public class DataAccessProd implements DataAccess {
    @Value("${prod}")
    private String prod;
    private DataAccess dataAccess;

    public DataAccessProd(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void hello(){

        System.out.println("Production DATA "+prod);
    }
}

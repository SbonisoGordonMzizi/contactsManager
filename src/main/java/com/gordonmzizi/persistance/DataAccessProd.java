package com.gordonmzizi.persistance;

import org.springframework.beans.factory.annotation.Value;

public class DataAccessProd implements DataAccess {
    @Value("${prod}")
    private String prod;

    @Override
    public void hello(){

        System.out.println("Production DATA "+prod);
    }
}

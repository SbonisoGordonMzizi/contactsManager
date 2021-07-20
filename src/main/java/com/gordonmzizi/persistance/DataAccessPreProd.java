package com.gordonmzizi.persistance;


import org.springframework.beans.factory.annotation.Value;

public class DataAccessPreProd implements DataAccess{
    @Value("${preprod}")
    private String preprod;

    @Override
    public void hello() {
        System.out.println("Pre-Production DATA "+this.preprod);
    }
}

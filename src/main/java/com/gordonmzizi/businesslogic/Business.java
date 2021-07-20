package com.gordonmzizi.businesslogic;

import com.gordonmzizi.persistance.DataAccess;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class Business implements EnvironmentAware {
   private DataAccess dataAccess;
   private Environment environment;

    public Business(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }


    public DataAccess getDataAccessProd() {
        return dataAccess;
    }

    public void getEnvironment() {
        System.out.println(Arrays.toString(this.environment.getActiveProfiles()));
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}

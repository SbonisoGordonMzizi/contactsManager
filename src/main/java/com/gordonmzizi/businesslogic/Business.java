package com.gordonmzizi.businesslogic;

import com.gordonmzizi.persistance.DataAccess;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.Map;


public class Business implements EnvironmentAware {
   private DataAccess dataAccess;
   private Environment environment;


    public Business(DataAccess dataAccess) {

        this.dataAccess = dataAccess;
    }

    @Override
    public void setEnvironment(Environment environment) {

        this.environment = environment;
    }

    public ArrayList<Map<String,String>> viewContact(){
        return dataAccess.viewContact();
    }

    public void addContact(ArrayList<Map<String,String>> contact){
        dataAccess.addContact(contact);
    }
    public void deleteContact(String name){
        dataAccess.deleteContact(name);
    }
    public void updateContact(ArrayList<Map<String,String>> contact){
       dataAccess.updateContact(contact);
    }

}

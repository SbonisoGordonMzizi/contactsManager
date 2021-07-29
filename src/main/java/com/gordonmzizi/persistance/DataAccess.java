package com.gordonmzizi.persistance;

import java.util.ArrayList;
import java.util.Map;

public interface DataAccess{
    void addContact(ArrayList<Map<String,String>> contact) ;
    ArrayList<Map<String,String>> viewContact() ;
    void deleteContact(String name);
    void updateContact(ArrayList<Map<String,String>> contact);
}

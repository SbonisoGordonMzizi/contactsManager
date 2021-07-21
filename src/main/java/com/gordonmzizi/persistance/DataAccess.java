package com.gordonmzizi.persistance;

import java.util.ArrayList;

public interface DataAccess {
    void addContact();
    ArrayList<String> viewContact();
    void deleteContact();
    void updateContact();
}

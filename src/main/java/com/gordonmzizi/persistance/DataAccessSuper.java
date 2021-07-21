package com.gordonmzizi.persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAccessSuper implements DataAccess{
    private JdbcTemplate jdbcTemplate;

    public DataAccessSuper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addContact() {
        Integer numberOfRowsAffected = jdbcTemplate.update("INSERT INTO contacts VALUES(1003,'Ally','ally@gmail.com')");
    }

    @Override
    public ArrayList<String> viewContact() {
        ArrayList<String> contacts = new ArrayList<>();

        jdbcTemplate.query("SELECT * FROM contacts", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                contacts.add(id);
                contacts.add(name);
                contacts.add(email);

            }
        });

        return contacts;
    }

    @Override
    public void deleteContact() {

        Integer numberOfRowsAffected = jdbcTemplate.update("DELETE FROM contacts WHERE name = 'Bob'");
    }

    @Override
    public void updateContact() {
        Integer numberOfRowsAffected = jdbcTemplate.update("UPDATE contacts SET email = 'newEmail@gmail.com' WHERE name = 'Bob'");
    }
}

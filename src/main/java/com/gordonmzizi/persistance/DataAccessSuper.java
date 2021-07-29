package com.gordonmzizi.persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class DataAccessSuper implements DataAccess{
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;


    public DataAccessSuper(JdbcTemplate jdbcTemplate,DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }


    @Override
    public void addContact(ArrayList<Map<String,String>> contact)  {
        String name = contact.get(0).get("name");
        String phoneNumber = contact.get(0).get("phoneNumber");
        Integer numberOfRowsAffected = jdbcTemplate.update("INSERT INTO contacts(name,phoneNumber) VALUES("+"\'"+name+"\'"+","+"\'"+phoneNumber+"\'"+")");
        clean();
    }

    @Override
    public ArrayList<Map<String,String>> viewContact()  {
        ArrayList<Map<String,String>>contacts = new ArrayList<>();
       Map<String,String> contact = new HashMap<>();
        jdbcTemplate.query("SELECT * FROM contacts", new RowCallbackHandler() {
            int count = 0;

            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                contact.put("name"+count,name);
                contact.put("phoneNumber"+count,phoneNumber);
                contacts.add(contact);
                count = count + 1;

            }

        });
        clean();
        return contacts;
    }

    @Override
    public void deleteContact(String name) {
       jdbcTemplate.execute("DELETE FROM contacts WHERE name = "+"\'"+name+"\'");
       clean();
    }

    @Override
    public void updateContact(ArrayList<Map<String,String>> contact) {
        String name = contact.get(0).get("name");
        String phoneNumber = contact.get(0).get("phoneNumber");
        jdbcTemplate.execute("UPDATE contacts SET phoneNumber = "+"\'"+phoneNumber+"\'"+" WHERE name ="+"\'"+name+"\'");
        clean();
    }

    public void clean(){
        try {
              dataSource.getConnection().close();

        }catch (SQLException e){

        }
    }
}

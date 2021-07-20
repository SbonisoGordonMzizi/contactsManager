package com.gordonmzizi.Config;

import com.gordonmzizi.businesslogic.Business;
import com.gordonmzizi.persistance.DataAccess;
import com.gordonmzizi.persistance.DataAccessProd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Profile("prod")
@Configuration
@PropertySource("classpath:application-pro.properties")
public class AppConfigProd {

    @Bean
    Business business(){
       return new Business(dataAccess());
    }

    @Bean
    DataAccess dataAccess(){
        return new DataAccessProd(dataSource());
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://192.168.1.5:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("mzizi45");

        return dataSource;
    }
}

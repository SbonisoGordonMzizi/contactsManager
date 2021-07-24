package com.gordonmzizi.Config;

import com.gordonmzizi.businesslogic.Business;
import com.gordonmzizi.persistance.DataAccess;
import com.gordonmzizi.persistance.DataAccessProd;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Profile("prod")
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.gordonmzizi")
@PropertySource("classpath:application-pro.properties")
public class AppConfigProd {

    @Bean
    Business business(){
       return new Business(dataAccess());
    }

    @Bean
    DataAccess dataAccess(){
        return new DataAccessProd(dataSource(),jdbcTemplate());
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://192.168.1.6:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("mzizi45");

        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}

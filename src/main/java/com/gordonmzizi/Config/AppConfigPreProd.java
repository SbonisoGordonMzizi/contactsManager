package com.gordonmzizi.Config;

import com.gordonmzizi.businesslogic.Business;
import com.gordonmzizi.persistance.DataAccess;
import com.gordonmzizi.persistance.DataAccessPreProd;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Profile("pre-prod")
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.gordonmzizi")
@PropertySource("classpath:application-pre-prod.properties")
public class AppConfigPreProd {
    @Bean
    Business business(){
        return new Business(dataAccess());
    }

    @Bean
    DataAccess dataAccess(){
        return new DataAccessPreProd(dataSource(),jdbcTemplate());
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:~/Desktop/Database/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("db");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}

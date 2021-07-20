package com.gordonmzizi.Config;

import com.gordonmzizi.businesslogic.Business;
import com.gordonmzizi.persistance.DataAccess;
import com.gordonmzizi.persistance.DataAccessProd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

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
        return new DataAccessProd();
    }
}

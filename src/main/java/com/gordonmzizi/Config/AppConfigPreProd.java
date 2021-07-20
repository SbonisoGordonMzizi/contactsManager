package com.gordonmzizi.Config;

import com.gordonmzizi.businesslogic.Business;
import com.gordonmzizi.persistance.DataAccess;
import com.gordonmzizi.persistance.DataAccessPreProd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("pre-prod")
@Configuration
@PropertySource("classpath:application-pre-prod.properties")
public class AppConfigPreProd {
    @Bean
    Business business(){
        return new Business(dataAccess());
    }

    @Bean
    DataAccess dataAccess(){
        return new DataAccessPreProd();
    }
}

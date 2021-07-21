package com.gordonmzizi;

import com.gordonmzizi.Config.AppConfigPreProd;
import com.gordonmzizi.Config.AppConfigProd;
import com.gordonmzizi.businesslogic.Business;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main( String[] args ) {
        //System.setProperty("spring.profiles.active","prod");
        System.setProperty("spring.profiles.active","pre-prod");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigProd.class, AppConfigPreProd.class);
        Business business = context.getBean(Business.class);
        business.getDataAccessProd().deleteContact();
        business.getEnvironment();
    }
}

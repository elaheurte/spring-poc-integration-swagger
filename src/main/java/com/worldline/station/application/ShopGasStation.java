package com.worldline.station.application;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main class to invoke 
 * @author ericlaheurte
 *
 */
@SpringBootApplication
@EnableWebMvc
@EnableIntegration
@ComponentScan(basePackages = "com.worldline.station")
public class ShopGasStation {

    private static final Logger log = Logger.getLogger(ShopGasStation.class);

	public static void main(String[] args) {
        SpringApplication.run(ShopGasStation.class, args);
    }

}



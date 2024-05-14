package com.jesusfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@SpringBootApplication
@EntityScan("org.openapitools.client.model.*")
public class ApiFirstServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiFirstServerApplication.class, args);
    }
}
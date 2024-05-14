package com.jesusfc.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading data...");
    }
}

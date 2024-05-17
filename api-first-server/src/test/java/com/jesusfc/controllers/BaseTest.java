package com.jesusfc.controllers;

import com.jesusfc.database.repository.CustomerRepository;
import com.jesusfc.database.repository.CustomerRepositoryImpl;
import com.jesusfc.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@SpringBootTest
public class BaseTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;


    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

}

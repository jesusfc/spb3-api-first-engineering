package com.jesusfc.controllers;

import com.jesusfc.model.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@SpringBootTest
class CustomerControllerTest extends BaseTest {

    @DisplayName("Get by Id")
    @Test
    void testGetCustomerById() throws Exception {

        Customer testCustomer = customerRepository.findAll().iterator().next();

        mockMvc.perform(get(CustomerController.BASE_URL + "/{customerId}", testCustomer.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testCustomer.getId().toString()));
    }


    @DisplayName("Test Customer List")
    @Test
    void testListCustomers() throws Exception {
        mockMvc.perform(get(CustomerController.BASE_URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }


}
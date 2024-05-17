package com.jesusfc;

import com.jesusfc.database.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@SpringBootTest
class ApiFirstServerApplicationTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void contextLoads() {
        assertThat(new ApiFirstServerApplication()).isNotNull();
    }

    @Test
    void testDataLoad() {
       assertThat(customerRepository.count()).isPositive();
    }
}

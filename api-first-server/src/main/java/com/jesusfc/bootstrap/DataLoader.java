package com.jesusfc.bootstrap;

import com.jesusfc.database.repository.CustomerRepository;
import com.jesusfc.model.Address;
import com.jesusfc.model.Customer;
import com.jesusfc.model.Name;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@Slf4j
@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        log.info("Loading data...");

        Customer customer = new Customer();
        Name customerName = new Name();
        customerName.setFirstName("Jesús");
        customerName.setLastName("Fdez");
        customer.setName(customerName);
        customer.setEmail("jesus.fdez.caraballo@gmail.com");
        customer.setPhoneNumber("+34 654 321 321");

        Address address = new Address();
        customer.setBillingAddress(address);
        customer.setShipToAddress(address);

        customerRepository.save(customer);

        for (Customer customer1 : customerRepository.findAll()) {
            log.info(String.valueOf(customer1));
        }


    }
}

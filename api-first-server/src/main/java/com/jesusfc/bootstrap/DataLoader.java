package com.jesusfc.bootstrap;

import com.jesusfc.database.entity.CustomerEntity;
import com.jesusfc.database.repository.CustomerRepository;
import com.jesusfc.mappers.CustomerMapper;
import com.jesusfc.model.AddressDto;
import com.jesusfc.model.CustomerDto;
import com.jesusfc.model.NameDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private final CustomerMapper customerMapper;

    @Override
    public void run(String... args) throws Exception {

        log.info("Loading data...");

        CustomerDto customer = new CustomerDto();
        NameDto customerName = new NameDto();
        customerName.setFirstName("Jesús");
        customerName.setLastName("Fdez");
        customer.setName(customerName);
        customer.setEmail("jesus.fdez.caraballo@gmail.com");
        customer.setPhoneNumber("+34 654 321 321");

        AddressDto address = new AddressDto();
        customer.setBillingAddress(address);
        customer.setShipToAddress(address);

        customerRepository.save(customerMapper.customerDtoToCustomerEntity(customer));

        CustomerDto customer2 = new CustomerDto();
        NameDto customerName2 = new NameDto();
        customerName2.setFirstName("Abel");
        customerName2.setLastName("Vives");
        customer2.setName(customerName2);
        customer2.setEmail("jfcaraballo@gmail.com");
        customer2.setPhoneNumber("+34 600 852 123");

        AddressDto address2 = new AddressDto();
        customer2.setBillingAddress(address2);
        customer2.setShipToAddress(address2);

        customerRepository.save(customerMapper.customerDtoToCustomerEntity(customer2));


        List<CustomerEntity> all = customerRepository.findAll();
        all.forEach(cus -> System.out.println(cus.getName().getFirstName()));

    }
}

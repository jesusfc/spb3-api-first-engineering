package com.jesusfc.services;

import com.jesusfc.database.repository.CustomerRepository;
import com.jesusfc.model.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> listCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .toList();
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }
}

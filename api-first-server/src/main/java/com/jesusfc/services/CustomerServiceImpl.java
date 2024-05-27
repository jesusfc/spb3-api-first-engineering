package com.jesusfc.services;

import com.jesusfc.custonException.NotFoundException;
import com.jesusfc.database.entity.CustomerEntity;
import com.jesusfc.database.repository.CustomerRepository;
import com.jesusfc.mappers.CustomerMapper;
import com.jesusfc.model.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> listCustomers() {
        List<CustomerEntity> all = customerRepository.findAll();
        return all.stream().map(customerMapper::customerEntityToCustomerDto).toList();
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {

        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow(NotFoundException::new);
        return customerMapper.customerEntityToCustomerDto(customerEntity);

        //Optional<CustomerEntity> customerEntityOpt = customerRepository.findById(customerId);
        //return customerEntityOpt.map(customerMapper::customerEntityToCustomerDto).orElse(null);
    }
}

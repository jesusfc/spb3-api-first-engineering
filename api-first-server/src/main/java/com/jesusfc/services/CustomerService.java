package com.jesusfc.services;

import com.jesusfc.model.CustomerDto;

import java.util.List;
import java.util.UUID;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
public interface CustomerService {

    List<CustomerDto> listCustomers();

    CustomerDto getCustomerById(UUID customerId);

}

package com.jesusfc.database.repository;



import com.jesusfc.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}

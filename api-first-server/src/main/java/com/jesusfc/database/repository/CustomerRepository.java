package com.jesusfc.database.repository;

import org.openapitools.client.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}

package com.jesusfc.database.repository;

import com.jesusfc.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final Map<UUID, Customer> entityMap = new HashMap<>();

    @Override
    public <S extends Customer> S save(S entity) {

        UUID id = UUID.randomUUID();
        Customer customer = new Customer();
/*
        customer.set

        if (entity.getBillToAddress() != null){
            builder1.billToAddress(Address.builder()
                    .id(UUID.randomUUID())
                    .addressLine1(entity.getBillToAddress().getAddressLine1())
                    .addressLine2(entity.getBillToAddress().getAddressLine2())
                    .city(entity.getBillToAddress().getCity())
                    .state(entity.getBillToAddress().getState())
                    .zip(entity.getBillToAddress().getZip())
                    .build());
        }

        if (entity.getShipToAddress() != null) {
            builder1.shipToAddress(Address.builder()
                    .id(UUID.randomUUID())
                    .addressLine1(entity.getShipToAddress().getAddressLine1())
                    .addressLine2(entity.getShipToAddress().getAddressLine2())
                    .city(entity.getShipToAddress().getCity())
                    .state(entity.getShipToAddress().getState())
                    .zip(entity.getShipToAddress().getZip())
                    .build());
        }

        if (entity.getPaymentMethods() != null) {
            builder1.paymentMethods(entity.getPaymentMethods()
                    .stream()
                    .map(paymentMethod -> PaymentMethod.builder()
                            .id(UUID.randomUUID())
                            .cardNumber(paymentMethod.getCardNumber())
                            .expiryMonth(paymentMethod.getExpiryMonth())
                            .expiryYear(paymentMethod.getExpiryYear())
                            .build())
                    .collect(Collectors.toList()));
        }

        Customer customer = builder1.email(entity.getEmail())
                .name(entity.getName())
                .phone(entity.getPhone())
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();
*/
        entityMap.put(id, customer);

        return (S) customer;
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Customer> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {

    }

    @Override
    public void deleteAll() {

    }
}

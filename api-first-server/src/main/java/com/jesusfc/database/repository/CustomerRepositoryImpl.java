package com.jesusfc.database.repository;

import com.jesusfc.model.Address;
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

        customer.setId(id);

        Address address = new Address();
        address.setId(UUID.randomUUID());
        address.setAddressLine1(entity.getBillingAddress().getAddressLine1());
        address.setAddressLine2(entity.getBillingAddress().getAddressLine2());
        address.setCity(entity.getBillingAddress().getCity());
        address.setCountry(entity.getBillingAddress().getCountry());
        address.setPostalCode(entity.getBillingAddress().getPostalCode());
        customer.setBillingAddress(address);

        Address shipToAddress = new Address();
        shipToAddress.setId(UUID.randomUUID());
        shipToAddress.setAddressLine1(entity.getShipToAddress().getAddressLine1());
        shipToAddress.setAddressLine2(entity.getShipToAddress().getAddressLine2());
        shipToAddress.setCity(entity.getShipToAddress().getCity());
        shipToAddress.setCountry(entity.getShipToAddress().getCountry());
        shipToAddress.setPostalCode(entity.getShipToAddress().getPostalCode());
        customer.setShipToAddress(shipToAddress);

        /*
        if (entity.getPaymentMethods()) {
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.paymentMethods(entity.getPaymentMethods()
                    .stream()
                    .map(paymentMethod -> PaymentMethod.builder()
                            .id(UUID.randomUUID())
                            .cardNumber(paymentMethod.getCardNumber())
                            .expiryMonth(paymentMethod.getExpiryMonth())
                            .expiryYear(paymentMethod.getExpiryYear())
                            .build())
                    .collect(Collectors.toList()));

            customer.setPaymentMethod(paymentMethod);
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

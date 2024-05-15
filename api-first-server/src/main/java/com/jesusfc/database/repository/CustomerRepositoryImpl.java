package com.jesusfc.database.repository;

import com.jesusfc.model.Address;
import com.jesusfc.model.Customer;
import com.jesusfc.model.Name;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

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
        address.setId(id);
        address.setAddressLine1(entity.getBillingAddress().getAddressLine1());
        address.setAddressLine2(entity.getBillingAddress().getAddressLine2());
        address.setCity(entity.getBillingAddress().getCity());
        address.setCountry(entity.getBillingAddress().getCountry());
        address.setPostalCode(entity.getBillingAddress().getPostalCode());
        customer.setBillingAddress(address);

        Address shipToAddress = new Address();
        shipToAddress.setId(id);
        shipToAddress.setAddressLine1(entity.getShipToAddress().getAddressLine1());
        shipToAddress.setAddressLine2(entity.getShipToAddress().getAddressLine2());
        shipToAddress.setCity(entity.getShipToAddress().getCity());
        shipToAddress.setCountry(entity.getShipToAddress().getCountry());
        shipToAddress.setPostalCode(entity.getShipToAddress().getPostalCode());
        customer.setShipToAddress(shipToAddress);


        if (!CollectionUtils.isEmpty(entity.getPaymentMethods())) {
            /*
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
            */
        }

        customer.setEmail(entity.getEmail());
        customer.setPhoneNumber(entity.getPhoneNumber());
        Name name = entity.getName();
        name.setId(id);
        customer.setName(name);

        entityMap.put(id, customer);
        return (S) customer;
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Customer> findById(UUID uuid) {
        return Optional.of(entityMap.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return findById(uuid).isPresent();
    }

    @Override
    public Iterable<Customer> findAll() {
        return entityMap.values();
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
        if (existsById(uuid)) entityMap.remove(uuid);
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

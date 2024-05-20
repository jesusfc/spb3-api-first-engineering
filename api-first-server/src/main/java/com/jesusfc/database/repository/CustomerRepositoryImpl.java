package com.jesusfc.database.repository;

import com.jesusfc.model.AddressDto;
import com.jesusfc.model.CustomerDto;
import com.jesusfc.model.NameDto;
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

    private final Map<UUID, CustomerDto> entityMap = new HashMap<>();

    @Override
    public <S extends CustomerDto> S save(S entity) {

        UUID id = UUID.randomUUID();
        CustomerDto CustomerDto = new CustomerDto();

        CustomerDto.setId(id);

        AddressDto address = new AddressDto();
        address.setId(id);
        address.setAddressLine1(entity.getBillingAddress().getAddressLine1());
        address.setAddressLine2(entity.getBillingAddress().getAddressLine2());
        address.setCity(entity.getBillingAddress().getCity());
        address.setCountry(entity.getBillingAddress().getCountry());
        address.setPostalCode(entity.getBillingAddress().getPostalCode());
        CustomerDto.setBillingAddress(address);

        AddressDto shipToAddress = new AddressDto();
        shipToAddress.setId(id);
        shipToAddress.setAddressLine1(entity.getShipToAddress().getAddressLine1());
        shipToAddress.setAddressLine2(entity.getShipToAddress().getAddressLine2());
        shipToAddress.setCity(entity.getShipToAddress().getCity());
        shipToAddress.setCountry(entity.getShipToAddress().getCountry());
        shipToAddress.setPostalCode(entity.getShipToAddress().getPostalCode());
        CustomerDto.setShipToAddress(shipToAddress);


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

            CustomerDto.setPaymentMethod(paymentMethod);
            */
        }

        CustomerDto.setEmail(entity.getEmail());
        CustomerDto.setPhoneNumber(entity.getPhoneNumber());
        NameDto name = entity.getName();
        name.setId(id);
        CustomerDto.setName(name);

        entityMap.put(id, CustomerDto);
        return (S) CustomerDto;
    }

    @Override
    public <S extends CustomerDto> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CustomerDto> findById(UUID uuid) {
        return Optional.of(entityMap.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return findById(uuid).isPresent();
    }

    @Override
    public Iterable<CustomerDto> findAll() {
        return entityMap.values();
    }

    @Override
    public Iterable<CustomerDto> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return entityMap.size();
    }

    @Override
    public void deleteById(UUID uuid) {
        if (existsById(uuid)) entityMap.remove(uuid);
    }

    @Override
    public void delete(CustomerDto entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends CustomerDto> entities) {

    }

    @Override
    public void deleteAll() {

    }
}

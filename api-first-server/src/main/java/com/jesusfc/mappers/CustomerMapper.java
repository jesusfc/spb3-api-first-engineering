package com.jesusfc.mappers;

import com.jesusfc.database.entity.CustomerEntity;
import com.jesusfc.model.CustomerDto;
import org.mapstruct.Mapper;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@Mapper
public interface CustomerMapper {

    CustomerDto customerEntityToCustomerDto(CustomerEntity customerEntity);

    CustomerEntity customerDtoToCustomerEntity(CustomerDto customerDto);

}

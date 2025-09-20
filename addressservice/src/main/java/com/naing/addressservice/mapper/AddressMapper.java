package com.naing.addressservice.mapper;

import org.mapstruct.Mapper;
import com.naing.addressservice.entity.Address;
import com.naing.addressservice.response.AddressResponse;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressResponse toResponse(Address address);
}

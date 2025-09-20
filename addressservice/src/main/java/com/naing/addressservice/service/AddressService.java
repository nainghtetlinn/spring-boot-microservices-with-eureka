package com.naing.addressservice.service;

import org.springframework.stereotype.Service;
import com.naing.addressservice.mapper.AddressMapper;
import com.naing.addressservice.repository.AddressRepo;
import com.naing.addressservice.response.AddressResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AddressService {
    private final AddressRepo addressRepo;
    private final AddressMapper addressMapper;

    public AddressResponse findAddressByEmployeeId(int employeeId) {
        return addressRepo.findAddressByEmployeeId(employeeId).map(addressMapper::toResponse)
                .orElse(null);
    }

}

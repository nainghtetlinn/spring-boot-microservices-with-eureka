package com.naing.addressservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.naing.addressservice.response.AddressResponse;
import com.naing.addressservice.service.AddressService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(
            @PathVariable("employeeId") int employeeId) {
        var address = addressService.findAddressByEmployeeId(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }
}

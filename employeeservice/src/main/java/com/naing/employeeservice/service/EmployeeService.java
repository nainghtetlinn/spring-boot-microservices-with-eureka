package com.naing.employeeservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.naing.employeeservice.feignclient.AddressClient;
import com.naing.employeeservice.mapper.EmployeeMapper;
import com.naing.employeeservice.repository.EmployeeRepo;
import com.naing.employeeservice.response.AddressResponse;
import com.naing.employeeservice.response.EmployeeResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;
    private final AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int id) {
        var employeeResponse =
                employeeRepo.findById(id).map(employeeMapper::toResponse).orElse(null);

        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressResponse(addressResponse.getBody());

        return employeeResponse;
    }
}

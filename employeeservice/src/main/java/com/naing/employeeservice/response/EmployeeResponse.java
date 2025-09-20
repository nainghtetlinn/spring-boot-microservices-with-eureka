package com.naing.employeeservice.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {
    private int id;
    private String name;
    private String email;
    private int age;
    private AddressResponse addressResponse;
}

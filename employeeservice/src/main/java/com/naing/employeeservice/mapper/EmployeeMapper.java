package com.naing.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.naing.employeeservice.entity.Employee;
import com.naing.employeeservice.response.EmployeeResponse;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "addressResponse", ignore = true)
    EmployeeResponse toResponse(Employee employee);

}

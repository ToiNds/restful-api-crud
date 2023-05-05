package com.toindph26899.restfulapicrud.service;

import com.toindph26899.restfulapicrud.entity.Customer;
import com.toindph26899.restfulapicrud.request.CustomerRequest;
import com.toindph26899.restfulapicrud.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAll();

    CustomerRequest findById(Long id);

    Customer save(CustomerRequest customerRequest);

    void delete(Long id);

}

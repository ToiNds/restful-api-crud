package com.toindph26899.restfulapicrud.rest;

import com.toindph26899.restfulapicrud.entity.Customer;
import com.toindph26899.restfulapicrud.request.CustomerRequest;
import com.toindph26899.restfulapicrud.response.CustomerResponse;
import com.toindph26899.restfulapicrud.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerResponse> findAll() {
        return customerService.findAll();
    }

    @PostMapping("/customers")
    public Customer save(@Valid @RequestBody CustomerRequest customerRequest) {
        return customerService.save(customerRequest);
    }

    @PutMapping("/customers")
    public Customer update(@Valid @RequestBody CustomerRequest customerRequest) {
        return customerService.save(customerRequest);
    }

    @DeleteMapping("/customers")
    public void delete(@RequestParam("customerId") Long id) {
        customerService.delete(id);
    }
}

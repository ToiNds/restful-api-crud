package com.toindph26899.restfulapicrud.service.impl;

import com.toindph26899.restfulapicrud.entity.Customer;
import com.toindph26899.restfulapicrud.exception.CustomerNotFoundException;
import com.toindph26899.restfulapicrud.repository.CustomerRepository;
import com.toindph26899.restfulapicrud.request.CustomerRequest;
import com.toindph26899.restfulapicrud.response.CustomerResponse;
import com.toindph26899.restfulapicrud.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private Customer customer = null;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponse> findAll() {
        return customerRepository.findAllCustom();
    }

    @Override
    public CustomerRequest findById(Long id) {

        Optional<Customer> customerOptional = customerRepository.findById(id);
        customer = null;

        if (customerOptional.isPresent()) {
            customer = customerOptional.get();
        } else {
            throw new CustomerNotFoundException("Customer not found by id - " + id);
        }

        CustomerRequest customerRequest = new CustomerRequest(
                customer.getId(), customer.getFirstName(), customer.getLastName(),
                String.valueOf(customer.getAge()), String.valueOf(customer.getGender()), customer.getAddress(),
                customer.getPhoneNumber(), customer.getStatus()
        );

        return customerRequest;
    }

    @Override
    public Customer save(CustomerRequest customerRequest) {

        customer = new Customer(
                customerRequest.getId(), customerRequest.getFirstName(), customerRequest.getLastName(),
                Integer.parseInt(customerRequest.getAge()), Boolean.valueOf(customerRequest.getGender()),
                customerRequest.getAddress(), customerRequest.getPhoneNumber(), customerRequest.getStatus()
        );

        Customer dbCustomer = customerRepository.save(customer);

        return dbCustomer;
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}

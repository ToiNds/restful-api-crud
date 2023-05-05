package com.toindph26899.restfulapicrud.repository;

import com.toindph26899.restfulapicrud.entity.Customer;
import com.toindph26899.restfulapicrud.response.CustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select new com.toindph26899.restfulapicrud.response.CustomerResponse(c.id, " +
            "c.firstName, c.lastName, c.age, c.gender, c.address, c.phoneNumber, c.status) " +
            "from Customer c")
    List<CustomerResponse> findAllCustom();

}

package com.toindph26899.restfulapicrud.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CustomerResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private Boolean gender;

    private String address;

    private String phoneNumber;

    private String status;

}

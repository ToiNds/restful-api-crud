package com.toindph26899.restfulapicrud.request;

import com.toindph26899.restfulapicrud.validation.AgeValidation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class CustomerRequest {

    private Long id;

    @NotNull(message = "First name not be empty")
    @Size(min = 3, max = 50, message = "First name from 3 to 50 characters")
    private String firstName;

    @NotNull(message = "Last name not be empty")
    @Size(min = 3, max = 50, message = "Last name from 3 to 50 characters")
    private String lastName;

    @NotNull(message = "Age not be empty")
    @Pattern(regexp = "^[0-9]+", message = "Age must be an integer")
    @AgeValidation(message = "Age between 18 to 50")
    private String age;

    @NotNull(message = "Gender not be empty")
    private String gender;

    @NotNull(message = "Address not be empty")
    private String address;

    @NotNull(message = "Phone number not be empty")
    @Pattern(regexp = "^0[0-9]{9}", message = "Phone number must be an integer and Phone number has 10 digits")
    private String phoneNumber;

    @NotNull(message = "Status not be empty")
    private String status;

}

package com.example.springjpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@NoArgsConstructor
public class CustomerDto {

    @JsonProperty("customerId")
    //@Positive
    private Long customerId;

    @JsonProperty("FirstName")
    @NotBlank
    private String firstName;

    @JsonProperty("LastName")
    @NotBlank
    private String lastName;

    @Null  //this annotation will make sure that client can not set this value in request
    private Long id;
}

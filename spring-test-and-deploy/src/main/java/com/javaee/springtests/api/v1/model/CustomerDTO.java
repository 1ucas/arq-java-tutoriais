package com.javaee.springtests.api.v1.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

	@NotBlank
    @Size(min = 2, max = 100)
	private String firstName;

	@NotBlank
    @Size(min = 2, max = 100)
    private String lastName;
    
	@NotBlank
    private String url;
}

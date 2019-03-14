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
public class VendorDTO {

	@NotBlank
    @Size(min = 2, max = 100)
	private String name;

	@NotBlank
    private String vendorUrl;
}

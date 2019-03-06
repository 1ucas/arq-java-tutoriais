package com.javaee.dockerizespringboot.controllers.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("This is a Dockerized Spring Boot Application")
@RestController
@RequestMapping(IndexController.BASE_URL)
public class IndexController {

public static final String BASE_URL = "/api/v1/index";
	
	@ApiOperation(value = "Get the Home Information")
	@GetMapping
	public String home() {
		return "Home Principal";
	}
}

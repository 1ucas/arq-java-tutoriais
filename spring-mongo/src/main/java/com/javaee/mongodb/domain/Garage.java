package com.javaee.mongodb.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Garage {

	@Id
	private String id;
	private String name;
	private String address;
	private GasStation gasStation;
	
	@DBRef
	private List<Category> categories = new ArrayList<>();
}

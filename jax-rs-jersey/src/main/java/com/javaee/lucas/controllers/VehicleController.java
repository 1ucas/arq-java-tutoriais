package com.javaee.lucas.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Vehicle;
import services.VehicleService;
import services.VehicleServiceImpl;

@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehicleController {
	
	private VehicleService vehicleService;
	
	public VehicleController() {
		vehicleService = new VehicleServiceImpl();
	}
	
//	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@GET
	public List<Vehicle> getAll(){
		System.out.println("Entrou Get");
//		logger.info("getAllVehicles: {}");
		List<Vehicle> vehicles = vehicleService.getAll();
		return vehicles;
	}
}

package com.javaee.mongodb.controllers.v1;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.mongodb.domain.Garage;
import com.javaee.mongodb.services.GarageService;

@RestController
@RequestMapping(GarageController.BASE_URL)
public class GarageController {

	public static final String BASE_URL = "/api/v1/garages";

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Garage> getAll(){
        return garageService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Garage getById(@PathVariable String id){
        return garageService.getGarageById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Garage create(@RequestBody Garage garage){
        return garageService.createNewGarage(garage);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Garage updateGarage(@PathVariable String id, @RequestBody Garage garage){
        return garageService.saveGarage(id, garage);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteGarage(@PathVariable String id){
    	garageService.deleteGarageById(id);
    }
}

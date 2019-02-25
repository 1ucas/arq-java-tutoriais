package com.javaee.mongodb.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.mongodb.domain.Garage;
import com.javaee.mongodb.repositories.GarageRepository;

@Service
public class GarageServiceImpl implements GarageService{
	private GarageRepository garageRepository;
	public GarageServiceImpl(GarageRepository garageRepository) {
		this.garageRepository = garageRepository;
	}

	@Override
	public Set<Garage> getAll() {
		Set<Garage> garares = new HashSet<>();
		this.garageRepository.findAll().iterator().forEachRemaining(garares::add);
		return garares;
	}

	@Override
	public Garage getGarageById(String id) {
		return getById(id);
	}
	
	private Garage getById(String id) {
		Optional<Garage> garageOptional = garageRepository.findById(id);

        if (!garageOptional.isPresent()) {
            throw new IllegalArgumentException("Garage Not Found For ID value: " + id.toString() );
        }
        return garageOptional.get();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Garage createNewGarage(Garage garage) {
		if(garageRepository.findByName(garage.getName()).isEmpty()) {			
			return garageRepository.save(garage);
		}else {
			throw new IllegalArgumentException("Garage Already Exists with name: " + garage.getName());
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Garage saveGarage(String id, Garage garage) {
		garage.setId(id);
		Garage garageSaved = garageRepository.save(garage);
		return garageSaved;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteGarageById(String id) {
		garageRepository.deleteById(id);
	}
}
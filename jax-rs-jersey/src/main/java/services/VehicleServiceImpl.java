package services;

import java.util.ArrayList;
import java.util.List;

import domain.Vehicle;

public class VehicleServiceImpl implements VehicleService {
	
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	public VehicleServiceImpl() {
		System.out.println("Vai Criar Veiculos");
		for(int i=0; i<10; i++) {
			Vehicle v = new Vehicle();
			v.setId(i);
			v.setName("Subaru" + i);
			v.setYear(2018);
			vehicles.add(v);
		}
	}

	public List<Vehicle> getAll() {
		System.out.println("Vai listar");
		return vehicles;
	}
}

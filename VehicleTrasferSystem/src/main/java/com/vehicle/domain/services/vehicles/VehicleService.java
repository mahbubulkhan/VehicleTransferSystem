package com.vehicle.domain.services.vehicles;


import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vehicle.domain.DomainObject;
import com.vehicle.domain.services.AbstractMapService;
import com.vehicle.domain.vehicles.VIN;
import com.vehicle.domain.vehicles.Vehicle;
import com.vehicle.domain.vehicles.VehiclesPerLocation;


@Service
public class VehicleService extends AbstractMapService{
	
	
	@Override
	public List<DomainObject> listAll()
	{
		return super.listAll();
	}
	
	@Override
	public Vehicle getById(Integer id)
	{
		return (Vehicle) super.getById(id);
	}
	
	
	public Vehicle saveOrUpdate(Vehicle domainObject) 
	{
        return (Vehicle) super.saveOrUpdate(domainObject);
    }
	
	 @Override
	public void delete(Integer id) 
	{
	        super.delete(id);
	}


	@Override
	protected void loadDomainObjects() {
		// TODO Auto-generated method stub
		domainMap = new HashMap<>();
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setId(1);
		vehicle1.setMake("Toyota");
		vehicle1.setModel("Camri");
		vehicle1.setYear("2001");
		VIN vin1 = new VIN();
		vin1.setVin("SDFG258GNLC2E08CR2050504");
		vehicle1.setVin(vin1);
		
		domainMap.put(1, vehicle1);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setId(2);
		vehicle2.setMake("Toyota");
		vehicle2.setModel("RAV4");
		vehicle2.setYear("2017");
		VIN vin2 = new VIN();
		vin2.setVin("AEFG258GNLC2E08CR2050504");
		vehicle2.setVin(vin2);
		domainMap.put(2, vehicle2);
		
		
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setId(3);
		vehicle3.setMake("Nissan");
		vehicle3.setModel("Altima");
		vehicle3.setYear("2007");
		
		VIN vin3 = new VIN();
		vin3.setVin("BDFG258GNLC2E08CR2050504");
		vehicle3.setVin(vin3);
		domainMap.put(3, vehicle3);
		
		VehiclesPerLocation location1 = new VehiclesPerLocation();
		location1.set_vehicle(vehicle1);
		

	}
	

}

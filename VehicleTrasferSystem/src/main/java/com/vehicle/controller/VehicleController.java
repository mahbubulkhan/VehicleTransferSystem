package com.vehicle.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vehicle.domain.DomainObject;
import com.vehicle.domain.services.vehicles.VehicleService;
import com.vehicle.domain.vehicles.Vehicle;


@Controller
public class VehicleController {
	
	private VehicleService vehicleService;

	
	/**
	 * @param vehicleService the vehicleService to set
	 */
	@Autowired
	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	//Shows all the vehicles
	public void listVehicle()
	{
		List<DomainObject> list = vehicleService.listAll();
		for(DomainObject element:list)
		{
			Vehicle vehicle = (Vehicle)element;
			System.out.println(vehicle.getId()+ vehicle.getMake() +" "+vehicle.getModel()+" "
					+vehicle.getYear()+" "+vehicle.getVin().getVin());
		}
			
	}
	
	//Show a particlular vehicle for a id
	public void showVehicle(Integer id)
	{
		Vehicle vehicle = vehicleService.getById(id);
		System.out.println(vehicle.getId()+ vehicle.getMake() +" "+vehicle.getModel()+" "
				+vehicle.getYear()+" "+vehicle.getVin().getVin());
	}
	
	public void deleteVehicle(int id)
	{
		vehicleService.delete(id);
	}
	
	
	public void editVehicle(Vehicle vehicle)
	{
		vehicleService.saveOrUpdate(vehicle);
	}
	
	public void addNewVehicle(Vehicle vehicle)
	{
		vehicleService.saveOrUpdate(vehicle);
	}

}

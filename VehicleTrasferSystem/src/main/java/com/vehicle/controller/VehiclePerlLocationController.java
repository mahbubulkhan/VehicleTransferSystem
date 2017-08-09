package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vehicle.domain.DomainObject;
import com.vehicle.domain.services.VehiclePerLocationService;
import com.vehicle.domain.vehicles.VehiclesPerLocation;

@Controller
public class VehiclePerlLocationController {
	
	private VehiclePerLocationService vehiclePerLocationService;

	
	/**
	 * @param vehiclePerLocationService the vehiclePerLocationService to set
	 */
	@Autowired
	public void setVehiclePerLocationService(VehiclePerLocationService vehiclePerLocationService) {
		this.vehiclePerLocationService = vehiclePerLocationService;
	}
	
	
	//Shows all the vehicles of different distribution centers and branches
	public void listVehiclesOfLocation()
	{
			List<DomainObject> list = vehiclePerLocationService.listAll();
			for(DomainObject element:list)
			{
				VehiclesPerLocation vehicleOfLocation = (VehiclesPerLocation)element;
				System.out.println(vehicleOfLocation.get_vehicle().getId() + " " +
						vehicleOfLocation.get_vehicle().getMake() +" "+
						vehicleOfLocation.get_vehicle().getModel()+" "+
						vehicleOfLocation.get_vehicle().getYear()+" "+
						vehicleOfLocation.get_vehicle().get_status().getValue() +" "+
						vehicleOfLocation.get_vehicle().get_vehicleTyle().name()+ " "+
						vehicleOfLocation.getDistributioncenter() + " "+
						vehicleOfLocation.getBranchID());
				
			}
				
	}
	
	// Delete a vehicle from a distribution center/branch
	public void deleteVehiclePerLocation(int id)
	{
		vehiclePerLocationService.delete(id);
	}
	
	public VehiclesPerLocation addNewVehiclePerLocation(VehiclesPerLocation vehicle)
	{
		return vehiclePerLocationService.saveOrUpdate(vehicle);
	}
	
	public VehiclesPerLocation showVehiclePerLocation(Integer id)
	{
		return vehiclePerLocationService.getById(id)
;	}
	
	//Transfers a vehicle from one distribution center/branch to another distribution center/branch
	public boolean tranferVehiclesBetweenDistributionCenters(Integer vehicleID,DomainObject distributionCenterID)
	{
		return vehiclePerLocationService.tranferVehiclesInDistributionCenters(vehicleID,distributionCenterID);
	}

	
	
	

}

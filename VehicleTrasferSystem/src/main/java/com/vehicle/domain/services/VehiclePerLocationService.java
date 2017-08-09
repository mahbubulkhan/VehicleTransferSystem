package com.vehicle.domain.services;


import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vehicle.domain.DomainObject;
import com.vehicle.domain.locations.Branch;
import com.vehicle.domain.locations.DistributionCenter;
import com.vehicle.domain.vehicles.Status;
import com.vehicle.domain.vehicles.VIN;
import com.vehicle.domain.vehicles.Vehicle;
import com.vehicle.domain.vehicles.VehicleType;
import com.vehicle.domain.vehicles.VehiclesPerLocation;


@Service
public class VehiclePerLocationService extends AbstractMapService{

	@Override
	public List<DomainObject> listAll()
	{
		return super.listAll();
	}
	
	@Override
	public VehiclesPerLocation getById(Integer id)
	{
		return (VehiclesPerLocation) super.getById(id);
	}
	
	
	public VehiclesPerLocation saveOrUpdate(VehiclesPerLocation domainObject) 
	{
        return (VehiclesPerLocation) super.saveOrUpdate(domainObject);
    }
	
	 @Override
	public void delete(Integer id) 
	{
	        super.delete(id);
	}
	 
	public boolean tranferVehiclesInDistributionCenters(Integer ID, DomainObject distributionCenter) {
		VehiclesPerLocation location = (VehiclesPerLocation) super.getById(ID);
		Vehicle _vehicle = location.get_vehicle();
		
		//Check if the vehicle is in transit status
		if (_vehicle.get_status() == Status.TRANSIT)
		{
			//Check If the vehicle i sof type semi and has to be transferred between distribution center
			if( _vehicle.get_vehicleTyle() == VehicleType.SEMI &&  (distributionCenter instanceof DistributionCenter)) 
			{
				location.setDistributioncenter(distributionCenter.getId());
				super.saveOrUpdate(location);
				return true;
			}
			////Check If the vehicle i sof type Truck or Van  and can be transferred between branches
			else if( (_vehicle.get_vehicleTyle() == VehicleType.TRCUK || _vehicle.get_vehicleTyle() == VehicleType.VAN)
					&& (distributionCenter instanceof Branch))
			{
				location.setBranchID(distributionCenter.getId());
				super.saveOrUpdate(location);
				return true;
			}
			else 
			{
				return false;
			}
		}
		else
			return false;
		
		
	}
	
	
	
	@Override
	protected void loadDomainObjects() {
		// TODO Auto-generated method stub
		
		domainMap = new HashMap<>();
		
		VehiclesPerLocation location1 = new VehiclesPerLocation();
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setId(1);
		vehicle1.setMake("Toyota");
		vehicle1.setModel("Camri");
		vehicle1.setYear("2001");
		vehicle1.set_vehicleTyle(VehicleType.SEMI);
		vehicle1.set_status(Status.TRANSIT);
		VIN vin1 = new VIN();
		vin1.setVin("SDFG258GNLC2E08CR2050504");
		vehicle1.setVin(vin1);
		location1.set_vehicle(vehicle1);
		
		DistributionCenter center1 = new DistributionCenter();
		center1.setId(1);
		location1.setDistributioncenter(center1.getId());
		domainMap.put(1, location1);
		
		VehiclesPerLocation location2 = new VehiclesPerLocation();
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setId(2);
		vehicle2.setMake("Toyota");
		vehicle2.setModel("RAV4");
		vehicle2.setYear("2015");
		vehicle2.set_vehicleTyle(VehicleType.VAN);
		vehicle2.set_status(Status.TRANSIT);
		VIN vin2 = new VIN();
		vin1.setVin("SDFG258GNLC2E08CR2050112");
		vehicle2.setVin(vin2);
		location2.set_vehicle(vehicle2);
		
		DistributionCenter center2 = new DistributionCenter();
		center2.setId(2);
		location2.setDistributioncenter(center2.getId());
		
		Branch branch1 = new Branch();
		branch1.setId(1);
		location2.setBranchID(branch1.getId());
		
		domainMap.put(2, location2);
		
		
		
		
	}
	
	

}

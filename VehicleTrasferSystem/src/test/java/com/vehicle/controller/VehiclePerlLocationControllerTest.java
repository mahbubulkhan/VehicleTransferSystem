package com.vehicle.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vehicle.domain.locations.Branch;
import com.vehicle.domain.locations.DistributionCenter;
import com.vehicle.domain.vehicles.Status;
import com.vehicle.domain.vehicles.VIN;
import com.vehicle.domain.vehicles.Vehicle;
import com.vehicle.domain.vehicles.VehicleType;
import com.vehicle.domain.vehicles.VehiclesPerLocation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehiclePerlLocationControllerTest {
	
	@Autowired
	VehiclePerlLocationController vehiclePerlLocationController;

	
	@Before
	public void loadVehiclesPerDomainObjects()
	{
		VehiclesPerLocation location3 = new VehiclesPerLocation();
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setId(3);
		vehicle3.setMake("NISSAN");
		vehicle3.setModel("Murano");
		vehicle3.setYear("2001");
		vehicle3.set_vehicleTyle(VehicleType.SEMI);
		vehicle3.set_status(Status.TRANSIT);
		VIN vin3 = new VIN();
		vin3.setVin("SDFG258GNLC2E08CR2051504");
		vehicle3.setVin(vin3);
		location3.set_vehicle(vehicle3);
		
		DistributionCenter center1 = new DistributionCenter();
		center1.setId(1);
		location3.setDistributioncenter(center1.getId());
		
		vehiclePerlLocationController.addNewVehiclePerLocation(location3);
		
		//Vehicle of type truck is added
		VehiclesPerLocation location4 = new VehiclesPerLocation();
		Vehicle vehicle4 = new Vehicle();
		vehicle4.setId(4);
		vehicle4.setMake("Toyota");
		vehicle4.setModel("Tundra");
		vehicle4.setYear("2001");
		vehicle4.set_vehicleTyle(VehicleType.TRCUK);
		vehicle4.set_status(Status.TRANSIT);
		VIN vin4 = new VIN();
		vin4.setVin("SDFG258GNLC2E08CR2051504");
		vehicle4.setVin(vin4);
		location4.set_vehicle(vehicle4);
		
		
		location4.setDistributioncenter(center1.getId());
		
		vehiclePerlLocationController.addNewVehiclePerLocation(location4);
		
		
		//Adding a vehicle which is of status Repair
		VehiclesPerLocation location5 = new VehiclesPerLocation();
		Vehicle vehicle5 = new Vehicle();
		vehicle5.setId(5);
		vehicle5.setMake("Toyota");
		vehicle5.setModel("SIENA");
		vehicle5.setYear("2010");
		vehicle5.set_vehicleTyle(VehicleType.VAN);
		vehicle5.set_status(Status.REPAIR);
		VIN vin5 = new VIN();
		vin5.setVin("SDFG258GNLC2E08CR2051504");
		vehicle5.setVin(vin5);
		location5.set_vehicle(vehicle5);
		
		
		location5.setDistributioncenter(center1.getId());
		
		vehiclePerlLocationController.addNewVehiclePerLocation(location5);
		
		//Adding a vehicle of type VAN
		
		VehiclesPerLocation location6 = new VehiclesPerLocation();
		Vehicle vehicle6 = new Vehicle();
		vehicle6.setId(6);
		vehicle6.setMake("Honda");
		vehicle6.setModel("Oddesey");
		vehicle6.setYear("2015");
		vehicle6.set_vehicleTyle(VehicleType.VAN);
		vehicle6.set_status(Status.TRANSIT);
		VIN vin6 = new VIN();
		vin6.setVin("SDFG258GNLC2E08CR2051504");
		vehicle6.setVin(vin6);
		location6.set_vehicle(vehicle6);
		
		
		location6.setDistributioncenter(center1.getId());
		
		vehiclePerlLocationController.addNewVehiclePerLocation(location6);
	}
	
	//It shows whether a vehicle exits 
	@Test
	public void testshowVehiclePerLocation() {
		VehiclesPerLocation vehicle = vehiclePerlLocationController.showVehiclePerLocation(1);
		assertNotNull(vehicle);
			
		}
	
	
	@Test
	public void testaddNewvwhiclePerlocation()
	{
		VehiclesPerLocation location = new VehiclesPerLocation();
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setId(3);
		vehicle1.setMake("Toyota");
		vehicle1.setModel("Camri");
		vehicle1.setYear("2001");
		vehicle1.set_vehicleTyle(VehicleType.SEMI);
		vehicle1.set_status(Status.TRANSIT);
		VIN vin1 = new VIN();
		vin1.setVin("SDFG258GNLC2E08CR2050504");
		vehicle1.setVin(vin1);
		location.set_vehicle(vehicle1);
		
		DistributionCenter center1 = new DistributionCenter();
		center1.setId(1);
		location.setDistributioncenter(center1.getId());
		assertNotNull(vehiclePerlLocationController.addNewVehiclePerLocation(location));
		
	}
	
	@Test
	public void trasferVehicle()
	{
		DistributionCenter center1 = new DistributionCenter();
		center1.setId(1);
		assertFalse(
			vehiclePerlLocationController.tranferVehiclesBetweenDistributionCenters(5, center1));
	}
	
	//Tests whether a vehicle of type SEMI can be transferred between distribution center to distribution center
	@Test
	public void tranferSemitoDistributionCenter()
	{
				
		DistributionCenter center2 = new DistributionCenter();
		center2.setId(2);
		
		assertTrue(vehiclePerlLocationController.tranferVehiclesBetweenDistributionCenters(3, center2));
		
	}
	
	//Tests whether a vehicle of type SEMI can be transferred to branch
	public void tranferSemitoBranch()
	{
				
		Branch branch = new Branch();
		branch.setId(2);
		
		assertFalse(vehiclePerlLocationController.tranferVehiclesBetweenDistributionCenters(3, branch));
		
	}
	
	//It tests whether a Truck can be transferred to any distribution center
	@Test
	public void transferTrucktoDistributionCenter()
	{
		DistributionCenter center2 = new DistributionCenter();
		center2.setId(2);
		assertFalse(
		vehiclePerlLocationController.tranferVehiclesBetweenDistributionCenters(4, center2));
	}
	
	//It checks whether a truck can be transferred to a branch
	@Test
	public void transferTrucktoBranch()
	{
		Branch branch = new Branch();
		branch.setId(3);
		assertTrue(
		vehiclePerlLocationController.tranferVehiclesBetweenDistributionCenters(4, branch));
	}
	
	
	@Test
	public void transferVentoDistributionCenter()
	{
		DistributionCenter center = new DistributionCenter();
		center.setId(2);
		assertFalse(
		vehiclePerlLocationController.tranferVehiclesBetweenDistributionCenters(6, center));
	}
	
	
	@Test
	public void transferVentoBranch()
	{
		Branch branch = new Branch();
		branch.setId(3);
		assertTrue(
		vehiclePerlLocationController.tranferVehiclesBetweenDistributionCenters(6, branch));
	}
 


}

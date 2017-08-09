package com.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vehicle.controller.BranchController;
import com.vehicle.controller.DistributionCenterController;
import com.vehicle.controller.VehicleController;
import com.vehicle.controller.VehiclePerlLocationController;
import com.vehicle.domain.locations.Branch;
import com.vehicle.domain.locations.DistributionCenter;
import com.vehicle.domain.vehicles.VIN;
import com.vehicle.domain.vehicles.Vehicle;

@SpringBootApplication
public class VehicleTrasferSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(VehicleTrasferSystemApplication.class, args);
		/*VehicleController cControlelr = (VehicleController) ctx.getBean("vehicleController");
		cControlelr.listVehicle();
		cControlelr.showVehicle(2);
		cControlelr.deleteVehicle(1);
		cControlelr.listVehicle();
		
		Vehicle v1 = new Vehicle();
		
		v1.setMake("Volvo");
		v1.setModel("LE");
		v1.setYear("2001");
		VIN vin = new VIN();
		vin.setVin("SDFG258GNLC2E08CR2050515");
		v1.setVin(vin);
		cControlelr.addNewVehicle(v1);
		cControlelr.listVehicle();
		
		BranchController brachController = (BranchController) ctx.getBean("branchController");
		brachController.listBranches();
		brachController.showBranch(2);
		Branch newbranch = new Branch();
		newbranch.setId(4);

		brachController.addNewBranch(newbranch);
		brachController.listBranches();
		brachController.deleteBranch(1);
		brachController.listBranches();
		
		System.out.println("Distribution Centers: ");
		DistributionCenterController dcenterController = 
				(DistributionCenterController)ctx.getBean("distributionCenterController");
		
		dcenterController.listDistributionCenters();
		dcenterController.showDistributionCenter(2);
		dcenterController.deleteDistributionCenter(2);
		dcenterController.listDistributionCenters();
		
		
		
		
		DistributionCenter center = new DistributionCenter();
		center.setId(10);
		dcenterController.addDistributionCenter(center);
		dcenterController.listDistributionCenters();*/
		
		
		VehiclePerlLocationController vehiclePerlLocationController =
				(VehiclePerlLocationController)ctx.getBean("vehiclePerlLocationController");
		vehiclePerlLocationController.listVehiclesOfLocation();
		DistributionCenter center = new DistributionCenter();
		center.setId(2);
		System.out.println(vehiclePerlLocationController.tranferVehiclesBetweenDistributionCenters(1, center));
		vehiclePerlLocationController.listVehiclesOfLocation();
		
		
		
	}
}

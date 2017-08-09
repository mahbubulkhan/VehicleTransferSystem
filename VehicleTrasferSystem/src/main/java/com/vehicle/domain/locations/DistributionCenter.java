package com.vehicle.domain.locations;


import java.util.HashSet;
import java.util.Set;

import com.vehicle.domain.DomainObject;
import com.vehicle.domain.vehicles.Vehicle;

public class DistributionCenter implements DomainObject{
	private int id;
	
	private Set<Branch> branches = new HashSet<Branch>();
	private Set<Vehicle> vehicles = new HashSet<>();
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id  =id;
	}

	/**
	 * @return the branches
	 */
	public Set<Branch> getBranches() {
		return  branches;
	}

	/**
	 * @param branches the branches to set
	 */
	public void setBranches(Set<Branch> branches) {
		this.branches =  branches;
	}

	/**
	 * @return the vehicles
	 */
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}

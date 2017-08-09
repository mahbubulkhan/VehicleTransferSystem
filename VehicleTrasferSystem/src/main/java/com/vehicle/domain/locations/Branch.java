package com.vehicle.domain.locations;

import java.util.ArrayList;
import java.util.List;

import com.vehicle.domain.DomainObject;
import com.vehicle.domain.vehicles.Vehicle;

public class Branch implements DomainObject {
	private Integer id;
	private List<Vehicle> poolofvehicles = new ArrayList<Vehicle>();
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	/**
	 * @return the pool of vehicles
	 */
	public List<Vehicle> getPoolofvehicles() {
		return poolofvehicles;
	}

	/**
	 * @param poolofvehicles the pool of vehicles to set
	 */
	public void setPoolofvehicles(List<Vehicle> poolofvehicles) {
		this.poolofvehicles = poolofvehicles;
	}

}

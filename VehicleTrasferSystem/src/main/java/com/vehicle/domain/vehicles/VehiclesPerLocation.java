package com.vehicle.domain.vehicles;

import com.vehicle.domain.DomainObject;

public class VehiclesPerLocation implements DomainObject {
	
	private Integer id;
	private Vehicle _vehicle;
	private Integer distributioncenter;
	private Integer branchID;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.id ;
	}
	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	
	
	/**
	 * @return the _vehicle
	 */
	public Vehicle get_vehicle() {
		return _vehicle;
	}
	/**
	 * @param _vehicle the _vehicle to set
	 */
	public void set_vehicle(Vehicle _vehicle) {
		this._vehicle = _vehicle;
	}
	/**
	 * @return the distribution center for the vehicle where it is located
	 */
	public Integer getDistributioncenter() {
		return distributioncenter;
	}
	/**
	 * @param distributioncenter the distribution center to set
	 */
	public void setDistributioncenter(Integer distributioncenter) {
		this.distributioncenter = distributioncenter;
	}
	/**
	 * @return the branchID where the vehicle is located
	 */
	public Integer getBranchID() {
		return branchID;
	}
	/**
	 * @param branchID the branchID to set the location of the vehicle
	 */
	public void setBranchID(Integer branchID) {
		this.branchID = branchID;
	}
	
	
	
	
	

}

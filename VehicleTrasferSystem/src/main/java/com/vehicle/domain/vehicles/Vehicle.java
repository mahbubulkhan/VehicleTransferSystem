package com.vehicle.domain.vehicles;

import com.vehicle.domain.DomainObject;

public class Vehicle implements DomainObject {
	
	private Integer id;
	private String make;
	private String model;
    private String year;
    private Status _status;
    private VehicleType _vehicleTyle;
    private VIN vin;
   
    
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
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the _status
	 */
	public Status get_status() {
		return _status;
	}
	/**
	 * @param _status the _status to set
	 */
	public void set_status(Status _status) {
		this._status = _status;
	}
	/**
	 * @return the _vehicleTyle
	 */
	public VehicleType get_vehicleTyle() {
		return _vehicleTyle;
	}
	/**
	 * @param _vehicleTyle the _vehicleTyle to set
	 */
	public void set_vehicleTyle(VehicleType _vehicleTyle) {
		this._vehicleTyle = _vehicleTyle;
	}
	/**
	 * @return the vin
	 */
	public VIN getVin() {
		return vin;
	}
	/**
	 * @param vin the vin to set
	 */
	public void setVin(VIN vin) {
		this.vin = vin;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
	//It checks whether Year consists of 4 numeric characters otherwise throws a runtime exception
		if(year.matches("\\d{4}"))
			this.year = year;
		else
			throw new RuntimeException("Year must of 4 numeric cahracters");
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
    

}

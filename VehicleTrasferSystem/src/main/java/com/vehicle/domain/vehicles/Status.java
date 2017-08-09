package com.vehicle.domain.vehicles;

public enum Status {
	
	STANDBY ("Stand-By"),TRANSIT("In Transit"),SERVICE("In Service"),REPAIR("In Repair");
    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue()
    {
        return this.value;
    }

}

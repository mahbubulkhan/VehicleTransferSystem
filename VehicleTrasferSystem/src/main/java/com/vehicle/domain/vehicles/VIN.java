package com.vehicle.domain.vehicles;

public class VIN {
	
	private String vin;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		if(validateVin(vin))
		{
			this.vin = getValidatedVin(vin);
		}
		else
			throw new RuntimeException("Vin is not valid");
		
	}
	
	
	public static boolean validateVin(String str)
    {
       if (str.length() == 24
                && str.replaceAll("[^a-zA-Z]", "").length() >= 8
                && str.matches(".*\\d{5}")
                ) {
            
            return true;
        } else {
            
            return false;
        }
    }

    public static String getValidatedVin(String vin)
    {
        vin = vin.replaceAll("[^A-Za-z0-9]","" ).toUpperCase();
        return vin;
    }
	
	

}

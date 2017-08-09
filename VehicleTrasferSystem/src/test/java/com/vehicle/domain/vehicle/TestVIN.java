package com.vehicle.domain.vehicle;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vehicle.domain.vehicles.VIN;

public class TestVIN {

	@Test
	public void testValidateVinWringFormat() {
		
		assertFalse(VIN.validateVin("sdfg258-!GNLC2E08CR205050-( 4$"));
	}
	
	@Test
	public void testValidateVinRightFormat() {
		String vin = "SDFG258GNLC2E08CR2051504";
		assertTrue(VIN.validateVin(vin));
	}

}

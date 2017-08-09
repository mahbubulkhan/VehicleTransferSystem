package com.vehicle.domain.vehicle;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vehicle.domain.vehicles.Vehicle;

// This class test whether the YEAR of vehicle contains 4 numeric characters
public class Testvehicle {

	@Test(expected = RuntimeException.class)
	public void testYear() {
		Vehicle vehicle = new Vehicle();
		try {
			vehicle.setYear("123456");
		} catch (RuntimeException re) {
			String message = "Year must of 4 numeric cahracters";
			assertEquals(message, re.getMessage());
			throw re;
		}
		
		fail("YEAR format checking didnt work!");

	}

}

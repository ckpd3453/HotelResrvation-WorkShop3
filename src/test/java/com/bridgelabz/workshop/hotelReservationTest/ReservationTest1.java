package com.bridgelabz.workshop.hotelReservationTest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.workshop.hotelReservation.ReservationFunctions1;

public class ReservationTest1 {

	/**
	 * JUnit Testing purpose
	 */
	
	//UC-1 Test Case
	@Test
	public void test() {

		ReservationFunctions1.addHotel("Lakewood", 110);
		ReservationFunctions1.addHotel("Bridgewood", 160);
		ReservationFunctions1.addHotel("Ridgewood", 220);
		Assert.assertEquals(3, ReservationFunctions1.countNoOfHotels());
	}

	//UC-2 Test Case
	@Test
	public void givenDetailsOf3Hotels_InAGivenDataRage_shouldReturnCheapesthotel() {

		ReservationFunctions1.addHotel("Lakewood", 110);
		ReservationFunctions1.addHotel("Bridgewood", 160);
		ReservationFunctions1.addHotel("Ridgewood", 220);
		String cheapestHotelInfo = ReservationFunctions1.findCheapestHotel("10-Sep-2020", "11-Sep-2020");
		Assert.assertEquals("Lakewood Total Cost: $110", cheapestHotelInfo);
	}
}

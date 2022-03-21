package com.bridgelabz.workshop.hotelReservationTest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.workshop.hotelReservation.ReservationFunctions6;

public class ReservationTest6 {

	/**
	 * JUnit Testing purpose
	 */
	//UC-7
	@Test
	public void given3Hotels_InAGivenDateRange_ShouldReturnBestRatedHotel() {

		ReservationFunctions6.addHotel("Lakewood", 110, 90, 3);
		ReservationFunctions6.addHotel("Bridgewood", 150, 50, 4);
		ReservationFunctions6.addHotel("Ridgewood", 220, 150, 5);
		String bestRatedHotelInfo = ReservationFunctions6.getBestRatedHotel("11 Sep 2020", "12 Sep 2020");
		Assert.assertEquals("Ridgewood, Total Cost: $370", bestRatedHotelInfo);
	}	
}

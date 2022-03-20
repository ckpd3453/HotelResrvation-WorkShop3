package com.bridgelabz.workshop.hotelReservationTest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.workshop.hotelReservation.ReservationFunctions5;

public class ReservationTest5 {

	/**
	 * JUnit Testing purpose
	 */
	//UC-6
	@Test
	public void given3Hotels_InAGivenDateRange_ShouldReturnCheapestBestRatedHotel() {
		
		ReservationFunctions5.addHotel("Lakewood", 110, 90, 3);
		ReservationFunctions5.addHotel("Bridgewood", 150, 50, 4);
		ReservationFunctions5.addHotel("Ridgewood", 220, 150, 5);
		String cheapestBestRatedHotelInfo = ReservationFunctions5.getCheapestBestRatedHotel("11 Sep 2020", "12 Sep 2020");
		Assert.assertEquals("Bridgewood, Rating: 4, Total Cost: $200", cheapestBestRatedHotelInfo);
	}		
}

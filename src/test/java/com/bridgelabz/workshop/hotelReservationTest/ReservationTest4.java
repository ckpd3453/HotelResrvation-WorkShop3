package com.bridgelabz.workshop.hotelReservationTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.workshop.hotelReservation.ReservationFunctions4;

public class ReservationTest4 {

	/**
	 * JUnit Testing purpose
	 */
	//UC-5
	@Test
	public void given3Hotels_WhenRatingsAdded_ShouldReturnRates() {

		ReservationFunctions4.addHotel("Lakewood", 110, 90,3);
		ReservationFunctions4.addHotel("Bridgewood", 160, 60,4);
		ReservationFunctions4.addHotel("Ridgewood", 220, 150,5);
		List<Integer> ratingList = new ArrayList<>();
		ReservationFunctions4.hotelList.stream().forEach(hotelDetails -> {
			ratingList.add(hotelDetails.getRating());
		});
		Assert.assertEquals(3, (int) ratingList.get(0));
		Assert.assertEquals(4, (int) ratingList.get(1));
		Assert.assertEquals(5, (int) ratingList.get(2));
	}
}

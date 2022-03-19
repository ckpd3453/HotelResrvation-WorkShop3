package com.bridgelabz.workshop.hotelReservationTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.workshop.hotelReservation.ReservationFunctions2;

public class ReservationTest2 {

	/**
	 * JUnit Testing purpose
	 */
	
	//UC-1 Test Case
	@Test
	public void test() {

		ReservationFunctions2.addHotel("Lakewood", 110, 90);
		ReservationFunctions2.addHotel("Bridgewood", 160, 60);
		ReservationFunctions2.addHotel("Ridgewood", 220, 150);
		Assert.assertEquals(3, ReservationFunctions2.countNoOfHotels());
	}

	//UC-2 Test Case
	@Test
	public void givenDetailsOf3Hotels_InAGivenDataRage_shouldReturnCheapesthotel() {

		ReservationFunctions2.addHotel("Lakewood", 110, 90);
		ReservationFunctions2.addHotel("Bridgewood", 160, 60);
		ReservationFunctions2.addHotel("Ridgewood", 220, 150);
		String cheapestHotelInfo = ReservationFunctions2.findCheapestHotel("10-Sep-2020", "11-Sep-2020");
		Assert.assertEquals("Lakewood Total Cost: $110", cheapestHotelInfo);
	}
	
	//UC-3 Test Case
	@Test
	public void givenDetailsOf3Hotels_WhenWeekdayAndWeekendRatesAdded_ShouldReturnThoseRates() {

			ReservationFunctions2.addHotel("Lakewood",110,90);
			ReservationFunctions2.addHotel("Bridgewood",160,60);
			ReservationFunctions2.addHotel("Ridgewood",220,150);
			List<Integer> weekendRoomRates = new ArrayList<>();
			List<Integer> weekdayRoomRates = new ArrayList<>();
			ReservationFunctions2.hotelList.stream().forEach(hotelDetails -> {
				weekendRoomRates.add(hotelDetails.getWeekendHotelRate());
				weekdayRoomRates.add(hotelDetails.getWeekdayHotelRate());
			String cheapestHotelInfo = ReservationFunctions2.findCheapestHotel("10 Sep 2020","11 Sep 2020");
			Assert.assertEquals("Lakewood Total Cost: $220",cheapestHotelInfo);
		});
			Assert.assertEquals(110, (int) weekdayRoomRates.get(0));
			Assert.assertEquals(160, (int) weekdayRoomRates.get(1));
			Assert.assertEquals(220, (int) weekdayRoomRates.get(2));
			Assert.assertEquals(90, (int) weekendRoomRates.get(0));
			Assert.assertEquals(60, (int) weekendRoomRates.get(1));
			Assert.assertEquals(150, (int) weekendRoomRates.get(2));
	}
}

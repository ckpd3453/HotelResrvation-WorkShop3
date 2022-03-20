package com.bridgelabz.workshop.hotelReservationTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.workshop.hotelReservation.ReservationFunctions3;

public class ReservationTest3 {

	/**
	 * JUnit Testing purpose
	 */
	
	//UC-1 Test Case
	@Test
	public void test() {

		ReservationFunctions3.addHotel("Lakewood", 110, 90);
		ReservationFunctions3.addHotel("Bridgewood", 160, 60);
		ReservationFunctions3.addHotel("Ridgewood", 220, 150);
		Assert.assertEquals(3, ReservationFunctions3.countNoOfHotels());
	}

	//UC-2 Test Case
	@Test
	public void shouldReturnCheapesthotel() {

		ReservationFunctions3.addHotel("Lakewood", 110, 90);
		ReservationFunctions3.addHotel("Bridgewood", 160, 60);
		ReservationFunctions3.addHotel("Ridgewood", 220, 150);
		String cheapestHotelInfo = ReservationFunctions3.findCheapestHotel("10-Sep-2020", "11-Sep-2020");
		Assert.assertEquals("Lakewood Total Cost: $110", cheapestHotelInfo);
	}
	
	//UC-3 Test Case
	@Test
	public void WeekdayAndWeekendRatesAdded_ShouldReturnThoseRates() {

			ReservationFunctions3.addHotel("Lakewood",110,90);
			ReservationFunctions3.addHotel("Bridgewood",160,60);
			ReservationFunctions3.addHotel("Ridgewood",220,150);
			List<Integer> weekendRoomRates = new ArrayList<>();
			List<Integer> weekdayRoomRates = new ArrayList<>();
			ReservationFunctions3.hotelList.stream().forEach(hotelDetails -> {
				weekendRoomRates.add(hotelDetails.getWeekendHotelRate());
				weekdayRoomRates.add(hotelDetails.getWeekdayHotelRate());
			String cheapestHotelInfo = ReservationFunctions3.findCheapestHotel("10 Sep 2020","11 Sep 2020");
			Assert.assertEquals("Lakewood Total Cost: $220",cheapestHotelInfo);
		});
			Assert.assertEquals(110, (int) weekdayRoomRates.get(0));
			Assert.assertEquals(160, (int) weekdayRoomRates.get(1));
			Assert.assertEquals(220, (int) weekdayRoomRates.get(2));
			Assert.assertEquals(90, (int) weekendRoomRates.get(0));
			Assert.assertEquals(60, (int) weekendRoomRates.get(1));
			Assert.assertEquals(150, (int) weekendRoomRates.get(2));
	}
	
	//UC-4 Test Case
	@Test
	public void ShouldReturnCheapestHotelBasedOnWeekdayAndWeekend() {
		ReservationFunctions3.addHotel("Lakewood", 110, 90);
		ReservationFunctions3.addHotel("Bridgewood", 150, 50);
		ReservationFunctions3.addHotel("Ridgewood", 220, 150);
		String cheapestHotelInfo = ReservationFunctions3.findCheapestHotel("11 Sep 2020", "12 Sep 2020");
		Assert.assertEquals("Lakewood, Bridgewood Total Cost: $200", cheapestHotelInfo);
	}
}

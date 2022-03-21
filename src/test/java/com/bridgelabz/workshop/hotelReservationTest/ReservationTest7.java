package com.bridgelabz.workshop.hotelReservationTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.workshop.hotelReservation.ReservationFunctions7;

public class ReservationTest7 {

	/**
	 * JUnit Testing purpose
	 */
	//UC-7
	@Test
	public void given3Hotels_WhenRatesForRewardsCustomerAdded_ShouldReturnTheRates() {
		
		ReservationFunctions7.addHotel("Lakewood", 110, 90, 80, 80, 3);
		ReservationFunctions7.addHotel("Bridgewood", 150, 50, 110, 50, 4);
		ReservationFunctions7.addHotel("Ridgewood", 220, 150, 100, 40, 5);
		List<Integer> weekdayRateListRewards = new ArrayList<>();
		List<Integer> weekendRateListRewards = new ArrayList<>();
		ReservationFunctions7.hotelList.stream().forEach(hotelDetails -> {
			weekdayRateListRewards.add(hotelDetails.getWeekdayRoomRateRewards());
		});
		ReservationFunctions7.hotelList.stream().forEach(hotelDetails -> {
			weekendRateListRewards.add(hotelDetails.getWeekendRoomRateRewards());
		});
		Assert.assertEquals(80, (int) weekdayRateListRewards.get(0));
		Assert.assertEquals(110, (int) weekdayRateListRewards.get(1));
		Assert.assertEquals(100, (int) weekdayRateListRewards.get(2));
		Assert.assertEquals(80, (int) weekendRateListRewards.get(0));
		Assert.assertEquals(50, (int) weekendRateListRewards.get(1));
		Assert.assertEquals(40, (int) weekendRateListRewards.get(2));
	}	
}

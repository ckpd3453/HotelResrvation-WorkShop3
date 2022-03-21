package com.bridgelabz.workshop.hotelReservationTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.workshop.hotelReservation.CustomerTypeException;
import com.bridgelabz.workshop.hotelReservation.ReservationFunctions9;

public class ReservationTest9 {

	/**
	 * JUnit Testing purpose
	 */
	//UC-9
	@Test
	public void given3Hotels_WhenRatesForRewardsCustomerAdded_ShouldReturnTheRates() {
		
		ReservationFunctions9.addHotel("Lakewood", 110, 90, 80, 80, 3);
		ReservationFunctions9.addHotel("Bridgewood", 150, 50, 110, 50, 4);
		ReservationFunctions9.addHotel("Ridgewood", 220, 150, 100, 40, 5);
		List<Integer> weekdayRateListRewards = new ArrayList<>();
		List<Integer> weekendRateListRewards = new ArrayList<>();
		ReservationFunctions9.hotelList.stream().forEach(hotelDetails -> {
			weekdayRateListRewards.add(hotelDetails.getWeekdayRoomRateRewards());
		});
		ReservationFunctions9.hotelList.stream().forEach(hotelDetails -> {
			weekendRateListRewards.add(hotelDetails.getWeekendRoomRateRewards());
		});
		Assert.assertEquals(80, (int) weekdayRateListRewards.get(0));
		Assert.assertEquals(110, (int) weekdayRateListRewards.get(1));
		Assert.assertEquals(100, (int) weekdayRateListRewards.get(2));
		Assert.assertEquals(80, (int) weekendRateListRewards.get(0));
		Assert.assertEquals(50, (int) weekendRateListRewards.get(1));
		Assert.assertEquals(40, (int) weekendRateListRewards.get(2));
	}	
	
	//UC-10
	@Test
	public void given3Hotels_WhenDateRangeProvidedForRewardsCustomer_ShouldReturnCheapestBestRatedHotel() {
		ReservationFunctions9 hotelReservation = new ReservationFunctions9();
		ReservationFunctions9.addHotel("Lakewood", 110, 90, 80, 80, 3);
		ReservationFunctions9.addHotel("Bridgewood", 150, 50, 110, 50, 4);
		ReservationFunctions9.addHotel("Ridgewood", 220, 150, 100, 40, 5);
		try{
			hotelReservation.typeOfCustomer("REWARDS");
		}
		catch(CustomerTypeException e) {
			e.printStackTrace();
		}
		String cheapestBestRatedHotelForRewards = hotelReservation.cheapestBestRatedHotelSelector("11 Sep 2020", "12 Sep 2020");
		System.out.println(cheapestBestRatedHotelForRewards);
		Assert.assertEquals("Ridgewood, Rating: 5, Total Cost: $140", cheapestBestRatedHotelForRewards);
	}		
}

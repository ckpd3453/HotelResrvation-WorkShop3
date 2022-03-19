package com.bridgelabz.workshop.hotelReservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class ReservationFunctions2 {
	
	/**
	 *Procedure:-
	 *============
	 *1. Created an ArrayList to store the hotel details
	 *2. Created a method to Add the hotel Details in the list
	 *3. Created a method to display the list 
	 *4. Created a method to find the cheapest rate of hotels
	 */
	
	
	/*
	 * 1. Created an Array List
	 */
	public static ArrayList<HotelDetails2> hotelList = new ArrayList<>();

	//getting hotel details into temporary object and adding into the array list
	public static void addHotel(String name, int weekdayRate, int weekendRate) {
		HotelDetails2 temporary = new HotelDetails2(name, weekdayRate, weekendRate);
		hotelList.add(temporary);
	}

	//getting size of an array list for testing purposes
	public static int countNoOfHotels() {
		return hotelList.size();
	}

	public static ArrayList<HotelDetails2> getHotelList() {
		return hotelList;
	}

	/*
	 *  UC1
	 *  2. Created a method to add the details of hotel
	 */
	public static void addHotel1(String hotelName, int weekDayRates, int weekEndRates) {
		HotelDetails2 list = new HotelDetails2(hotelName, weekDayRates, weekEndRates);
		hotelList.add(list);
	}

	/*
	 * 3. Created a method to display list
	 */
	public static void showHotel() {
		System.out.println("\n\n### List of Hotels ###\n" + hotelList);
	}

	/*
	 *  UC2
	 *  4. Created a method to find the Cheapest rate hotel in given duration
	 */
	public static String findCheapestHotel(String startDate, String endDate) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy"); //Created a pattern of date
		LocalDate startDateInput = LocalDate.parse(startDate, dateFormat);//Getting Start Date from user
		LocalDate endDateInput = LocalDate.parse(endDate, dateFormat);//Getting End Date from user
		int noOfDaysToBook = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;//Calculating the no. of days
		//Streaming the list of @Hotels and their @Rate and calculating the total rate of durations
		Map<String, Integer> hotelNameToTotalCostMap = hotelList.stream().collect(Collectors.toMap(hotel -> hotel.getName(), hotel -> hotel.getWeekdayHotelRate() * noOfDaysToBook));
		//Comparing the rates of hotels to find the cheapest rate
		String cheapestHotelName = hotelNameToTotalCostMap.keySet().stream()
				.min((hotel1, hotel2) -> hotelNameToTotalCostMap.get(hotel1) - hotelNameToTotalCostMap.get(hotel2))
				.orElse(null);
		//Storing Cheapest Hotel info the variable
		String cheapestHotelInfo = cheapestHotelName + ", Total Cost: $"
				+ hotelNameToTotalCostMap.get(cheapestHotelName);
		System.out.println(cheapestHotelInfo);
		return cheapestHotelInfo;

	}
}

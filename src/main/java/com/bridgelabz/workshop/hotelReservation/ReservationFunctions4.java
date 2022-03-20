package com.bridgelabz.workshop.hotelReservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReservationFunctions4 {
	
	/**
	 *Procedure:-
	 *============
	 *1. Created an ArrayList to store the hotel details
	 *2. Created a method to Add the hotel Details in the list
	 *3. Created a method to display the list 
	 *4. Created a method to find the cheapest rate of hotels in given duration including weekday and weekend rate
	 */
	
	
	/*
	 * 1. Created an Array List
	 */
	public static ArrayList<HotelDetails4> hotelList = new ArrayList<>();

	/*
	 * 2. getting hotel details into temporary object and adding into the array list
	 */
	public static void addHotel(String name, int weekdayRate, int weekendRate, int rating) {
		HotelDetails4 temporary = new HotelDetails4(name, weekdayRate, weekendRate, rating);
		hotelList.add(temporary);
	}

	//getting size of an array list for testing purposes
	public static int countNoOfHotels() {
		return hotelList.size();
	}

	public static ArrayList<HotelDetails4> getHotelList() {
		return hotelList;
	}
	
	/*
	 * 3. Created a method to display list
	 */
	public static void showHotel() {
		System.out.println("\n\n### List of Hotels ###\n" + hotelList);
	}

	/*
	 *  UC2
	 *  4. Created a method to find the Cheapest rate hotel in given duration including weekday and weekend rate
	 */
	public static String findCheapestHotel(String startDate, String endDate) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy"); //Created a pattern of date
		LocalDate startDateInput = LocalDate.parse(startDate, dateFormat);//Getting Start Date from user
		LocalDate endDateInput = LocalDate.parse(endDate, dateFormat);//Getting End Date from user
		int noOfDaysToBook = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;//Calculating the no. of days
		//Streaming the list of @Hotels and their @Rate and calculating the total rate of durations
		List<DayOfWeek> daysList = new ArrayList<>();
		daysList = Stream.iterate(startDateInput.getDayOfWeek(), day -> day.plus(1)).limit(noOfDaysToBook).collect(Collectors.toList());
		int noOfWeekends = (int) daysList.stream().filter(day -> 
		day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)).count();
		int noOfWeekdays = daysList.size() - noOfWeekends;
		int minCost = hotelList.get(0).getWeekdayHotelRate() * noOfWeekdays + hotelList.get(0).getWeekendHotelRate() * noOfWeekends ;
		List<String> cheapestHotelNameList = new ArrayList<>();
		cheapestHotelNameList.add(hotelList.get(0).getName());

		for(int i = 1; i < hotelList.size(); i++) {
			if(hotelList.get(i).getWeekdayHotelRate() * noOfWeekdays + hotelList.get(i).getWeekendHotelRate() * noOfWeekends < minCost) {
				minCost = hotelList.get(i).getWeekdayHotelRate() * noOfWeekdays + hotelList.get(i).getWeekendHotelRate() * noOfWeekends;
				for(int j = 0; j < cheapestHotelNameList.size(); j++) 
					cheapestHotelNameList.remove(j);
				cheapestHotelNameList.add(hotelList.get(i).getName());
			}
			if(hotelList.get(i).getWeekdayHotelRate() * noOfWeekdays + hotelList.get(i).getWeekendHotelRate() * noOfWeekends == minCost)
				cheapestHotelNameList.add(hotelList.get(i).getName());
		}
		String hotelNameString = cheapestHotelNameList.stream().collect(Collectors.joining(", "));
		String cheapestHotelInfo = hotelNameString + " Total Cost: $" + minCost;
		System.out.println(cheapestHotelInfo);
		return cheapestHotelInfo;
	}
}

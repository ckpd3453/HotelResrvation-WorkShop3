package com.bridgelabz.workshop.hotelReservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReservationFunctions9 {
	
	/**
	 *Procedure:-
	 *============
	 *1. Created an ArrayList to store the hotel details
	 *2. Created a method to Add the hotel Details in the list
	 *3. Created a method to display the list 
	 *4. Created a method to find the cheapest rate of hotels in given duration including weekday and weekend rate
	 *5. Created a method to find the Cheapest BestRated hotel in given duration including weekday and weekend rate
	 *6. Created a method to find the Best rated hotel in given duration including weekday and weekend rate
	 */
	
	
	public enum CustomerType {
		REGULAR, REWARDS
	}

	/*
	 * 1. Created an Array List
	 */
	public static ArrayList<HotelDetails9> hotelList = new ArrayList<>();

	/*
	 * 2. getting hotel details into temporary object and adding into the array list
	 */
	public static void addHotel(String name, int weekdayRoomRateRegulare, int weekendRoomRateRegular,int weekdayRoomRateRewards,int weekendRoomRateRewards, int rating) {
		HotelDetails9 temporary = new HotelDetails9(name, weekdayRoomRateRegulare, weekendRoomRateRegular, weekdayRoomRateRewards, weekendRoomRateRewards, rating);
		hotelList.add(temporary);
	}

	//getting size of an array list for testing purposes
	public static int countNoOfHotels() {
		return hotelList.size();
	}

	public static ArrayList<HotelDetails9> getHotelList() {
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
		int minCost = hotelList.get(0).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(0).getWeekendRoomRateRegular() * noOfWeekends ;
		List<String> cheapestHotelNameList = new ArrayList<>();
		cheapestHotelNameList.add(hotelList.get(0).getHotelName());

		for(int i = 1; i < hotelList.size(); i++) {
			if(hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends < minCost) {
				minCost = hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends;
				for(int j = 0; j < cheapestHotelNameList.size(); j++) 
					cheapestHotelNameList.remove(j);
				cheapestHotelNameList.add(hotelList.get(i).getHotelName());
			}
			if(hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends == minCost)
				cheapestHotelNameList.add(hotelList.get(i).getHotelName());
		}
		String hotelNameString = cheapestHotelNameList.stream().collect(Collectors.joining(", "));
		String cheapestHotelInfo = hotelNameString + " Total Cost: $" + minCost;
		System.out.println("Cheapest Hotel " + cheapestHotelInfo);
		return cheapestHotelInfo;
	}
	
	/*
	 *  UC6
	 *  5. Created a method to find the Cheapest BestRated hotel in given duration including weekday and weekend rate
	 */
	public static String getCheapestBestRatedHotel(String startDate, String endDate) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate startDateInput = LocalDate.parse(startDate, dateFormat);
		LocalDate endDateInput = LocalDate.parse(endDate, dateFormat);
		int noOfDaysToBook = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;
		List<DayOfWeek> daysList = new ArrayList<>();
		daysList = Stream.iterate(startDateInput.getDayOfWeek(), day -> day.plus(1)).limit(noOfDaysToBook).collect(Collectors.toList());
		int noOfWeekends = (int) daysList.stream().filter(day -> 
		day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)).count();
		int noOfWeekdays = daysList.size() - noOfWeekends;
		int minCost = hotelList.get(0).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(0).getWeekendRoomRateRegular() * noOfWeekends ;
		
		List<HotelDetails9> cheapestHotelList = new ArrayList<>();
		cheapestHotelList.add(hotelList.get(0));
		for(int i = 1; i < hotelList.size(); i++) {
			if(hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends < minCost) {
				minCost = hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends;
				for(int j = 0; j < cheapestHotelList.size(); j++) 
					cheapestHotelList.remove(j);
				cheapestHotelList.add(hotelList.get(i));
			}
			if(hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends == minCost)
				cheapestHotelList.add(hotelList.get(i));
		}
		HotelDetails9 cheapestBestRatedHotel = cheapestHotelList.stream().max((hotelOne, hotelTwo) -> hotelOne.getRating() -hotelTwo.getRating()).orElse(null);
		String cheapestBestRatedHotelInfo = cheapestBestRatedHotel.getHotelName() + ", Rating: " + cheapestBestRatedHotel.getRating() + ", Total Cost: $" + minCost;
		System.out.println("Cheapest Best Rated Hotel :- " + cheapestBestRatedHotelInfo);
		return cheapestBestRatedHotelInfo;
	}
	
	/*
	 *  UC7
	 *  6. Created a method to find the best rated hotel in given duration including weekday and weekend rate
	 */
	public static String getBestRatedHotel(String startDate, String endDate) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate startDateInput = LocalDate.parse(startDate, dateFormat);
		LocalDate endDateInput = LocalDate.parse(endDate, dateFormat);
		int noOfDaysToBook = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;
		List<DayOfWeek> daysList = new ArrayList<>();
		daysList = Stream.iterate(startDateInput.getDayOfWeek(), day -> day.plus(1)).limit(noOfDaysToBook).collect(Collectors.toList());
		int noOfWeekends = (int) daysList.stream().filter(day -> 
		day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)).count();
		int noOfWeekdays = daysList.size() - noOfWeekends;
		HotelDetails9 bestRatedHotel = hotelList.stream().max((hotelOne, hotelTwo) -> hotelOne.getRating() - hotelTwo.getRating()).orElse(null);
		int bestRatedCost = bestRatedHotel.getWeekdayRoomRateRegular() * noOfWeekdays + bestRatedHotel.getWeekendRoomRateRegular() * noOfWeekends;
		String bestRatedHotelInfo = bestRatedHotel.getHotelName() + ", Total Cost: $" + bestRatedCost;
		System.out.println(bestRatedHotelInfo);
		return bestRatedHotelInfo;
	}

	private Object typeOfCustomer;
	
	public String getCheapestBestRatedHotelForRewards (String startDate, String endDate) {
		String cheapestBestRatedHotelForRewardsInfo = null;
		try {
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
			LocalDate startDateInput = LocalDate.parse(startDate, dateFormat);
			LocalDate endDateInput = LocalDate.parse(endDate, dateFormat);
			int noOfDaysToBook = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;
			List<DayOfWeek> daysList = new ArrayList<>();
			daysList = Stream.iterate(startDateInput.getDayOfWeek(), day -> day.plus(1)).limit(noOfDaysToBook).collect(Collectors.toList());
			int noOfWeekends = (int) daysList.stream().filter(day -> 
			day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)).count();
			int noOfWeekdays = daysList.size() - noOfWeekends;
			int minCost = hotelList.get(0).getWeekdayRoomRateRewards() * noOfWeekdays + hotelList.get(0).getWeekendRoomRateRewards() * noOfWeekends ;
			List<HotelDetails9> cheapestHotelList = new ArrayList<>();
			cheapestHotelList.add(hotelList.get(0));
			//for and if used because we can have multiple hotels offering the same lowest total price until uc4
			for(int i = 1; i < hotelList.size(); i++) {
				if(hotelList.get(i).getWeekdayRoomRateRewards() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRewards() * noOfWeekends < minCost) {
					minCost = hotelList.get(i).getWeekdayRoomRateRewards() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRewards() * noOfWeekends;
					for(int j = 0; j < cheapestHotelList.size(); j++) 
						cheapestHotelList.remove(j);
					cheapestHotelList.add(hotelList.get(i));
				}
				if(hotelList.get(i).getWeekdayRoomRateRewards() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRewards() * noOfWeekends == minCost)
					cheapestHotelList.add(hotelList.get(i));
			}
			HotelDetails9 cheapestBestRatedHotelForRewards = cheapestHotelList.stream().max((hotelOne, hotelTwo) -> hotelOne.getRating() - hotelTwo.getRating()).orElse(null);
			cheapestBestRatedHotelForRewardsInfo = cheapestBestRatedHotelForRewards.getHotelName() + ", Rating: " + cheapestBestRatedHotelForRewards.getRating() + ", Total Cost: $" + minCost;
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			System.out.println("The format of dates(s) entered is incorrect!");
		}
		return cheapestBestRatedHotelForRewardsInfo;
	}

	public void typeOfCustomer(String typeOfCustomer) throws CustomerTypeException {
		if(CustomerType.REGULAR.name().equals(typeOfCustomer))
			this.typeOfCustomer = CustomerType.REGULAR;
		else if(CustomerType.REWARDS.name().equals(typeOfCustomer))
			this.typeOfCustomer = CustomerType.REWARDS;
		else throw new CustomerTypeException("Please enter only REGULAR or REWARDS!");
	}

	public String cheapestBestRatedHotelSelector(String startDate, String endDate) {
		if(typeOfCustomer == CustomerType.REGULAR)
			return getCheapestBestRatedHotel(startDate, endDate);
		else
			return getCheapestBestRatedHotelForRewards(startDate, endDate);
	}
}

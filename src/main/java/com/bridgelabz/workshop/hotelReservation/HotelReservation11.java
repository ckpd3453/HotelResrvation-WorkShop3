package com.bridgelabz.workshop.hotelReservation;

import java.util.Scanner;

public class HotelReservation11 {

	/**
	 * Procedure:- 
	 * ============= 
	 * UC-1 :- Added Hotels and their Rates
	 * UC-2 :- Method to get the Cheapest Rate Hotel in given Duration
	 *  
	 */


	/*
	 * Main method to pass the details of hotels
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("***********Welcome to Hotel Reservation************");

		for (int i = 1; i <= 3; i++) {
			System.out.println("Enter the hotel name : ");
			String hotelName = sc.next();
			System.out.println("Enter the Week-Days Regular Rates : ");
			int weekDayRatesRegular = sc.nextInt();
			System.out.println("Enter the Week-End Regular Rates : ");
			int weekEndRatesRegular = sc.nextInt();
			System.out.println("Enter the Week-Days Rewards Rates : ");
			int weekDayRatesRewards = sc.nextInt();
			System.out.println("Enter the Week-End Rewards Rates : ");
			int weekEndRatesRewards = sc.nextInt();
			System.out.println("Give Rating to the Hotels : ");
			int rating = sc.nextInt();
			ReservationFunctions11.addHotel(hotelName, weekDayRatesRegular,weekEndRatesRegular, weekDayRatesRewards, weekEndRatesRewards, rating);
		}
		ReservationFunctions11.showHotel();

		/*
		 * UC-2 To find Cheapest rate on given date intervals
		 */
		System.out.println("Enter the start date (DD-MMM-YYYY)");
		String sd = sc.next();
		System.out.println("Enter the end date (DD-MMM-YYYY)");
		String ed = sc.next();
		ReservationFunctions11.findCheapestHotel(sd, ed);
		ReservationFunctions11.getCheapestBestRatedHotel(sd, ed);
		ReservationFunctions11.getBestRatedHotel(sd, ed);
		ReservationFunctions11.getCheapestBestRatedHotelForRewards(sd, ed);
	}
}

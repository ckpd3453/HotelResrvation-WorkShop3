package com.bridgelabz.workshop.hotelReservation;

import java.util.Scanner;

public class HotelReservation4 {

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
			System.out.println("Enter the Week-Days Rates : ");
			int weekDayRates = sc.nextInt();
			System.out.println("Enter the Week-End Rates : ");
			int weekEndRates = sc.nextInt();
			System.out.println("Give Rating to the Hotels : ");
			int rating = sc.nextInt();
			ReservationFunctions4.addHotel(hotelName, weekDayRates,weekEndRates, rating);
		}
		ReservationFunctions4.showHotel();

		/*
		 * UC-2 To find Cheapest rate on given date intervals
		 */
		System.out.println("Enter the start date (DD-MMM-YYYY)");
		String sd = sc.next();
		System.out.println("Enter the end date (DD-MMM-YYYY)");
		String ed = sc.next();
		ReservationFunctions4.findCheapestHotel(sd, ed);
	}
}

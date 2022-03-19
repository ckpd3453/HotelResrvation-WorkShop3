package com.bridgelabz.workshop.hotelReservation;

import java.util.Scanner;

public class HotelReservation1 {

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
			System.out.println("Enter the Rates : ");
			int rates = sc.nextInt();
			ReservationFunctions1.addHotel1(hotelName, rates);
		}
		ReservationFunctions1.showHotel();

		/*
		 * UC-2 To find Cheapest rate on given date intervals
		 */
		System.out.println("Enter the start date (DD-MMM-YYYY)");
		String sd = sc.next();
		System.out.println("Enter the end date (DD-MMM-YYYY)");
		String ed = sc.next();
		ReservationFunctions1.findCheapestHotel(sd, ed);
	}
}

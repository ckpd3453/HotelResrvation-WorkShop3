package com.bridgelabz.workshop.hotelReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {
	
	/**
	 * Procedure:-
	 * =============
	 * 1. Created an ArrayList to store the Hotel Details 
	 * 2. getting hotel details into temporary object and adding into the array list for testing purposes
	 * 3. getting size of an array list for testing purposes
	 * 4. Main method to pass the details of hotels
	 */
	
	/*
	 *  Created an ArrayList to store the Hotel Details
	 */
	private static ArrayList<HotelDetails> hotelList = new ArrayList<>();

	/*
	 *  getting hotel details into temporary object and adding into the array list for testing purposes
	 */
	public static void addHotel(String name, int price) {
		HotelDetails temporary = new HotelDetails(name, price);
		hotelList.add(temporary);
	}

	/*
	 *  getting size of an array list for testing purposes
	 */
	public static int countNoOfHotels() {
		return hotelList.size();
	}

	/*
	 *  Main method to pass the details of hotels
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("***********Welcome to Hotel Reservation************");
		
		for(int i=1; i<=3;i++) {
		System.out.println("Enter the hotel name : ");
		String hotelName = sc.next();
		System.out.println("Enter the Rates : ");
		int rates = sc.nextInt();
		
		//Passing user input details into object of a constructor and adding that object to the arraylist
		HotelDetails list = new HotelDetails(hotelName , rates);
		hotelList.add(list);
		}
		System.out.println("\n\n### List of Hotels ###\n"+hotelList);
	}
}

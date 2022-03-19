package com.bridgelabz.workshop.hotelReservation;

public class HotelDetails1 {
	private String name;
	private int price;

	/**
	 * 1. Created a constructor
	 * 
	 * @param name
	 * @param price
	 */
	public HotelDetails1(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "\nHotelDetails [name=" + name + ", price=" + price + "]";
	}

}

package com.bridgelabz.workshop.hotelReservation;

public class HotelDetails6 {
	private String name;
	private int weekdayHotelRate;
	private int weekendHotelRate;
	private int rating;

	/**
	 * 1. Created a constructor
	 */

	public HotelDetails6(String name, int weekdayHotelRate, int weekendHotelRate, int rating) {
		super();
		this.name = name;
		this.weekdayHotelRate = weekdayHotelRate;
		this.weekendHotelRate = weekendHotelRate;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeekdayHotelRate() {
		return weekdayHotelRate;
	}

	public void setWeekdayHotelRate(int weekdayHotelRate) {
		this.weekdayHotelRate = weekdayHotelRate;
	}

	public int getWeekendHotelRate() {
		return weekendHotelRate;
	}

	public void setWeekendHotelRate(int weekendHotelRate) {
		this.weekendHotelRate = weekendHotelRate;
	}

	@Override
	public String toString() {
		return "\nHotelDetails4 [name=" + name + ", weekdayHotelRate=" + weekdayHotelRate + ", weekendHotelRate="
				+ weekendHotelRate + ", rating=" + rating + "]";
	}

}

package com.bridgelabz.workshop.hotelReservation;

public class HotelDetails3 {
	private String name;
	private int weekdayHotelRate;
	private int weekendHotelRate;

	/**
	 * 1. Created a constructor
	 */
	
	public HotelDetails3(String name, int weekdayHotelRate, int weekendHotelRate) {
		super();
		this.name = name;
		this.weekdayHotelRate = weekdayHotelRate;
		this.weekendHotelRate = weekendHotelRate;
	}

	public String getName() {
		return name;
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
		return "\nHotelDetails2 [name=" + name + ", weekdayHotelRate=" + weekdayHotelRate + ", weekendHotelRate="
				+ weekendHotelRate + "]";
	}


}

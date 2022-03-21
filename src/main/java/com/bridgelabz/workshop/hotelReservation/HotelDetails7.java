package com.bridgelabz.workshop.hotelReservation;

public class HotelDetails7 {
	private String hotelName;
	private int weekdayRoomRateRegular;
	private int weekendRoomRateRegular;
	private int weekdayRoomRateRewards;
	private int weekendRoomRateRewards;
	private int rating;
	
	/**
	 * 1. Created a constructor
	 */
	public HotelDetails7(String hotelName, int weekdayRoomRateRegular, int weekendRoomRateRegular,
			int weekdayRoomRateRewards, int weekendRoomRateRewards, int rating) {
		super();
		this.hotelName = hotelName;
		this.weekdayRoomRateRegular = weekdayRoomRateRegular;
		this.weekendRoomRateRegular = weekendRoomRateRegular;
		this.weekdayRoomRateRewards = weekdayRoomRateRewards;
		this.weekendRoomRateRewards = weekendRoomRateRewards;
		this.rating = rating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekdayRoomRateRegular() {
		return weekdayRoomRateRegular;
	}

	public void setWeekdayRoomRateRegular(int weekdayRoomRateRegular) {
		this.weekdayRoomRateRegular = weekdayRoomRateRegular;
	}

	public int getWeekendRoomRateRegular() {
		return weekendRoomRateRegular;
	}

	public void setWeekendRoomRateRegular(int weekendRoomRateRegular) {
		this.weekendRoomRateRegular = weekendRoomRateRegular;
	}

	public int getWeekdayRoomRateRewards() {
		return weekdayRoomRateRewards;
	}

	public void setWeekdayRoomRateRewards(int weekdayRoomRateRewards) {
		this.weekdayRoomRateRewards = weekdayRoomRateRewards;
	}

	public int getWeekendRoomRateRewards() {
		return weekendRoomRateRewards;
	}

	public void setWeekendRoomRateRewards(int weekendRoomRateRewards) {
		this.weekendRoomRateRewards = weekendRoomRateRewards;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "HotelDetails7 [hotelName=" + hotelName + ", weekdayRoomRateRegular=" + weekdayRoomRateRegular
				+ ", weekendRoomRateRegular=" + weekendRoomRateRegular + ", weekdayRoomRateRewards="
				+ weekdayRoomRateRewards + ", weekendRoomRateRewards=" + weekendRoomRateRewards + ", rating=" + rating
				+ "]";
	}	

}

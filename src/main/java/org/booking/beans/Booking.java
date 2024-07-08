package org.booking.beans;

import java.util.ArrayList;
import java.util.List;

public class Booking {


    private String userName;

    private String bookingID;

    private String hotelName;

    private String roomsBooked;

    private int totalCost;

    private String dateOfBooking;

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(String dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getRoomsBooked() {
        return roomsBooked;
    }

    public void setRoomsBooked(String roomsBooked) {
        this.roomsBooked = roomsBooked;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }



    public int getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userName='" + userName + '\'' +
                ", bookingID='" + bookingID + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", roomsBooked='" + roomsBooked + '\'' +
                ", totalCost=" + totalCost +
                ", dateOfBooking='" + dateOfBooking + '\'' +
                '}';
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}

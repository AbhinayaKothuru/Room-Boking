package org.booking.controllers;

import org.booking.services.BookingService;

public class BookingController {

    private BookingService bookingService = new BookingService();


    public boolean roomStatus(String roomNo, String hotel, String date) {

        try{
            return bookingService.roomStatusSvc(roomNo,hotel,date);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public void bookRoom(String name, String hotel, String roomNo, String date) {
        try{
            bookingService.bookRoomSvc(name,hotel,roomNo,date);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String viewBookings(String name) {
        try{
            return bookingService.getBookingsSvc(name);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }
}

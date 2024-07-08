package org.booking.services;

import org.booking.beans.Booking;
import org.booking.dao.BookingDao;

import java.util.List;

public class BookingService {

    private BookingDao bookingDao = new BookingDao();

    public boolean roomStatusSvc(String roomNo, String hotel, String date) {

        List<Booking> bookings = bookingDao.getAllBookings();
        if(bookings == null) return true;
        for(Booking booking : bookings)
        {
            if(booking.getRoomsBooked().contains(roomNo) && booking.getDateOfBooking().equals(date) && booking.getHotelName().equals(hotel))
            {
                return false;
            }
        }
        return true;

    }

    public void bookRoomSvc(String name, String hotel, String roomNo, String date) {

        bookingDao.bookRomDao(name,hotel,roomNo,date);


    }

    public String getBookingsSvc(String name) {

        List<Booking>bookings = bookingDao.getAllBookings();
        StringBuilder bookingInfo = new StringBuilder();
        if(bookings == null || bookings.isEmpty()) return "";
        for(Booking booking : bookings)
        {
            if(booking.getUserName().equals(name))
                bookingInfo.append(booking.toString());

        }
        return bookingInfo.toString();
    }
}

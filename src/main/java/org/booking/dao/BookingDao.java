package org.booking.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.booking.beans.Booking;
import org.booking.beans.Hotel;
import org.booking.beans.User;

import java.awt.print.Book;
import java.io.*;
import java.util.*;

public class BookingDao {

    private String filePath = "src/main/java/org/booking/data/Bookings.json";
    public List<Booking> getAllBookings() {
        Gson gson = new Gson();
        List<Booking> bookings = Collections.emptyList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            bookings = gson.fromJson(reader, new TypeToken<List<Booking>>(){}.getType());
        } catch (FileNotFoundException e) {
            bookings = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public boolean bookRomDao(String name, String hotel, String roomNo, String date) {

        Gson gson = new Gson();
        List<Booking> bookings = Collections.emptyList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            bookings = gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
        } catch (FileNotFoundException e) {
            bookings = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        if(bookings == null)  bookings = new ArrayList<>();
        UUID uuid = UUID.randomUUID();
        Booking booking = new Booking();
        booking.setBookingID(String.valueOf(uuid)); booking.setRoomsBooked(roomNo);
        booking.setHotelName(hotel); booking.setTotalCost(1000); booking.setDateOfBooking(date);
        booking.setUserName(name);
        bookings.add(booking);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            gson.toJson(bookings, writer);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

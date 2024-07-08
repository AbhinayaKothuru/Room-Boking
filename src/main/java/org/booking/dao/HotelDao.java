package org.booking.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.booking.beans.Hotel;
import org.booking.beans.User;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class HotelDao {


    private String filePath = "src/main/java/org/booking/data/Hotels.json";

    public List<Hotel> getAllHotelsDao() {
        Gson gson = new GsonBuilder().create();
        List<Hotel> hotels = null;

        try (Reader reader = new FileReader(filePath)) {
            // Convert JSON file to array of Person objects
            hotels = Arrays.asList(gson.fromJson(reader, Hotel[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hotels;
    }
}

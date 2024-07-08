package org.booking.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.booking.beans.Hotel;
import org.booking.beans.Room;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class RoomDao {

    String filePath = "src/main/java/org/booking/data/Rooms.json";
    public List<Room> getRoomDetailsOfHotelDao() {
        Gson gson = new GsonBuilder().create();
        List<Room> rooms = null;

        try (Reader reader = new FileReader(filePath)) {
            // Convert JSON file to array of Person objects
            rooms = Arrays.asList(gson.fromJson(reader, Room[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rooms;
    }
}

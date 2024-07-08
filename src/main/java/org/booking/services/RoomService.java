package org.booking.services;

import org.booking.beans.Room;
import org.booking.dao.RoomDao;

import java.util.List;

public class RoomService {

    private RoomDao roomDao = new RoomDao();


    public String getRoomDetailsOfHotelSvc(String hotelName) {

        List<Room>rooms = roomDao.getRoomDetailsOfHotelDao();
        String roomsInfo = "";
        int count=1;
        for(Room room: rooms)
        {
            if(room.getHotelName().equals(hotelName))
            {
                roomsInfo += count + ". ";
                roomsInfo += room.toString();
                count += 1;
            }
        }
        return roomsInfo;

    }
}

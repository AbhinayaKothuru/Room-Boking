package org.booking.controllers;

import org.booking.beans.Room;
import org.booking.services.RoomService;

import java.util.List;

public class RoomController {

    private RoomService roomService = new RoomService();

    public String getRoomDetailsOfHotel(String hotelName)
    {
        try{
            return roomService.getRoomDetailsOfHotelSvc(hotelName);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }
}

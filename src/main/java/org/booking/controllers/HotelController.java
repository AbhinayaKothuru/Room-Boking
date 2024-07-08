package org.booking.controllers;

import org.booking.beans.Hotel;
import org.booking.services.HotelService;

import java.util.List;

public class HotelController {

    private HotelService hotelService = new HotelService();

    public String getAllHotels()
    {
        try{
            return hotelService.getAllHotelsSvc();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }
}

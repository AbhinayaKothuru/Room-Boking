package org.booking.services;

import org.booking.beans.Hotel;
import org.booking.dao.HotelDao;

import java.util.List;

public class HotelService {

    private HotelDao hotelDao  = new HotelDao();

    public String getAllHotelsSvc() {
        List<Hotel> hotels= hotelDao.getAllHotelsDao();
        String hotelsInfo = "";
        int count=1;
        for(Hotel hotel: hotels)
        {
            hotelsInfo += count + ". ";
            hotelsInfo += hotel.toString();
            count+=1;
        }
        return hotelsInfo;
    }
}

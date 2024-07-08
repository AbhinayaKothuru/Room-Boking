package org.booking.beans;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;

    private List<String> rooms = new ArrayList<String>();

    private String description;

    private Boolean wifi;

    private Boolean ac;

    private String contactNo;

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }



    public List<String> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getAc() {
        return ac;
    }

    public void setAc(Boolean ac) {
        this.ac = ac;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", wifi=" + wifi +
                ", ac=" + ac +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}

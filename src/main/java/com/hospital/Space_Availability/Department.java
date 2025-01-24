package com.hospital.Space_Availability;

import java.util.ArrayList;
import java.util.List;

import com.hospital.HospitalEntity;

public class Department extends HospitalEntity{

    private List<Room> rooms;

    public Department(String name)
    {
        super(name);
        rooms = new ArrayList<>();
    }

    @Override
    public String toString() {
        String output="ID:"+id+" Oddział: "+name;
        return output;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public void removeObject(Boolean downCounter) {
    for (Room room : rooms) {
        room.removeObject(downCounter);
    }

    super.removeObject(downCounter);
}
}

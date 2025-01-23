package com.hospital.Space_Availability;

import java.util.ArrayList;
import java.util.List;

import com.hospital.HospitalEntity;

public class Department extends HospitalEntity{

    private List<Room> rooms;

    public Department(int id,String name)
    {
        super(id,name);
        rooms = new ArrayList<>();
    }

    @Override
    public String toString() {
        String output="Oddział: "+name;
        return output;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void DisplayDepartmentPlan()
    {
       return; //aktualnie wyświetlanie graficzne sal odpuszczam, zobaczymy czy się uda zrobić je potem
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

}

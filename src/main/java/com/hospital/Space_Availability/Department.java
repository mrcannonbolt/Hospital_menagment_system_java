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
        String output="Oddział: "+name+"z pokojami: \n";
        for (Room room : rooms) 
            {
               output+=room;
            }
        return output;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void DisplayDepartmentPlan()
    {
       return; //aktualnie wyświetlanie graficzne sal odpuszczam, zobaczymy czy się uda zrobić je potem
    }
}

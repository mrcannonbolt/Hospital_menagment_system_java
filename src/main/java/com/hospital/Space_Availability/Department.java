package com.hospital.Space_Availability;

import java.util.ArrayList;
import java.util.List;

import com.hospital.HospitalEntity;

public class Department extends HospitalEntity{

    List<Room> rooms;

    public Department(int id,String name)
    {
        super(id,name);
        rooms = new ArrayList<>();
    }

    @Override
    public void displayInfo() 
    {
        System.out.println
        (
            "nazwa oddziału: "+this.name+"\n"+
            "Sale na oddziale: "+"\n"
        );
        for (Room room : rooms) 
            {
                System.out.println(room);
            }
    }

    @Override
    public String toString() {
        String output="Odział: "+name+"z pokojami: \n";
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

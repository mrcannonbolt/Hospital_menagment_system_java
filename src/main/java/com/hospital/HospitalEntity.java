package com.hospital;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


// Klasa abstrakcyjna, która definiuje ogólne metody dla jednostek w systemie szpitalnym
public abstract class HospitalEntity{

    protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    static protected int counter = 1;
    protected int id;
    protected String name;
    protected Date date = new Date();

    public HospitalEntity(String name) {
        this.id = counter;
        counter++;
        this.name = name;
        App.listOfObjects.add(this);
    }
    
    public void removeObject(Boolean downCounter){
        if(downCounter == true) counter=counter-1;
        App.listOfObjects.remove(this);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    protected static <T> ObservableList<T> filterAndConvertToObservableList(List<?> list, Class<T> type) {

        List<T> filteredList = list.stream()
                                   .filter(type::isInstance)
                                   .map(type::cast)
                                   .collect(Collectors.toList());

        return FXCollections.observableArrayList(filteredList);
    }

}
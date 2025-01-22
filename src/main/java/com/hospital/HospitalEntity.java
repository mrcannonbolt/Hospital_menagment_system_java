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
    protected int id;
    protected String name;
    protected Date date = new Date();

    public HospitalEntity(int id, String name) {
        this.id = id;
        this.name = name;
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

    protected static <T> ObservableList<T> filterAndConvertToObservableList(List<?> list, Class<T> type) {

        List<T> filteredList = list.stream()
                                   .filter(type::isInstance)
                                   .map(type::cast)
                                   .collect(Collectors.toList());

        return FXCollections.observableArrayList(filteredList);
    }

}
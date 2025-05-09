package com.example.Java_Ngay3;

import java.util.Date;
import java.util.Scanner;

public class Event {

    Scanner scanner = new Scanner(System.in);

    private int eventId;

    private String eventName;

    private String location;

    private Date date;

    private int maxSeats;

    public Event() {
    }

    public Event(int eventId, String eventName, String location, Date date, int maxSeats) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.maxSeats = maxSeats;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    @Override
    public String toString() {
        return
                "eventId: " + eventId +
                        ", eventName: " + eventName +
                        ", location: " + location +
                        ", date: " + date +
                        ", maxSeats: " + maxSeats;
    }
}

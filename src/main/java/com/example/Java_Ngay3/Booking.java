package com.example.Java_Ngay3;

public class Booking {

    private String email;

    private int eventId;

    private int seatNumber;

    public Booking() {
    }

    public Booking(String email, int eventId, int seatNumber) {
        this.email = email;
        this.eventId = eventId;
        this.seatNumber = seatNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return
                "email: " + email +
                        ", eventId: " + eventId +
                        ", seatNumber: " + seatNumber;
    }
}

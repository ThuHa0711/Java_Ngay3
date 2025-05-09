package com.example.Java_Ngay3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EventBookingService {
    private List<Event> events = new ArrayList<>();
    private LinkedList<Booking> bookings = new LinkedList<>();
    private Map<Integer, HashSet<Integer>> bookedSeats = new HashMap<>();
    private Map<Integer, Integer> bookingStatistics = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    //Kiểm tra ID sự kiện có tồn tại không
    public boolean isEventExist(int eventId) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                return true;
            }
        }
        return false;
    }

    //Thêm sự kiện
    public void addEvent(Event event) {
        events.add(event);
    }

    //Hiển thị danh sách sự kiện
    public void displayEvents() {
        events.sort(Comparator.comparing(Event::getEventName));
        if (events.isEmpty()) {
            System.out.println("Danh sách sự kiện trống");
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    //Hiển thị danh sách đặt vé
    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("Danh sách đặt vé trống");
        } else {
            Iterator<Booking> iterator = bookings.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }

    //Tìm kiếm sự kiện theo tên
    public void searchEventByName() {
        if (events.isEmpty()) {
            System.out.println("Danh sách sự kiện trống");
        } else {
            boolean search = false;
            System.out.printf("Nhập tên sự kiện cần tìm: ");
            String eventName;
            do {
                eventName = scanner.nextLine();
                if (eventName.trim().isEmpty()) {
                    System.out.println("Tên sự kiện không được để trống");
                }
            } while (eventName.trim().isEmpty());

            for (Event event : events) {
                if (event.getEventName().equalsIgnoreCase(eventName)) {
                    System.out.println(event);
                    search = true;
                }
            }
            if (!search) {
                System.out.println("Không tìm thấy sự kiện " + eventName);
            }
        }
    }

    //Đặt vé
    public void bookTicket(String userEmail, int eventId, int seatNumber) {

        if (!isEventExist(eventId)) {
            System.out.println("ID sự kiện không tồn tại");
            return;
        }

        Event event = events.stream().filter(e -> e.getEventId() == eventId).findFirst().orElse(null);
        if (event != null && seatNumber > event.getMaxSeats()) {
            System.out.println("Seat number exceeds max seats of the event!");
            return;
        }

        HashSet<Integer> seats = bookedSeats.computeIfAbsent(eventId, k -> new HashSet<>());
        if (!seats.contains(seatNumber)) {
            seats.add(seatNumber);
            bookings.add(new Booking(userEmail, eventId, seatNumber));
            bookingStatistics.put(eventId, bookingStatistics.getOrDefault(eventId, 0) + 1);
            System.out.println("Đặt vé thành công");
        } else {
            System.out.println("Ghế đã có người đặt");
        }
    }

    //Thống kê lượt đặt vé theo sự kiện
    public void displayStatistics() {
        for (Map.Entry<Integer, Integer> entry : bookingStatistics.entrySet()) {
            System.out.println("Event ID: " + entry.getKey() + " - Số lượt đặt vé: " + entry.getValue());
        }
    }


}

package com.example.Java_Ngay3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EventBookingMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventBookingService eventBookingService = new EventBookingService();
        int eventId = 1;

        do {
            System.out.println("-- HỆ THỐNG ĐẶT VÉ SỰ KIỆN TRỰC TUYẾN --");
            System.out.println("1. Thêm sự kiện");
            System.out.println("2. Hiển thị danh sách sự kiện");
            System.out.println("3. Hiển thị danh sách đặt vé");
            System.out.println("4. Tìm kiếm sự kiện theo tên");
            System.out.println("5. Đặt vé");
            System.out.println("6. Thống kê lượt đặt vé theo sự kiện");
            System.out.println("7. Thoát");
            System.out.printf("Hãy chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1. Thêm sự kiện");

                    String eventName;
                    System.out.printf("Nhập tên sự kiện: ");
                    do {
                        eventName = scanner.nextLine();
                        if (eventName.trim().isEmpty()) {
                            System.out.println("Tên sự kiện không được để trống");
                            System.out.printf("Nhập tên sự kiện: ");
                        }
                    } while (eventName.trim().isEmpty());

                    String location;
                    System.out.printf("Nhập địa chỉ: ");
                    do {
                        location = scanner.nextLine();
                        if (location.trim().isEmpty()) {
                            System.out.println("Địa chỉ không được để trống");
                            System.out.printf("Nhập địa chỉ: ");
                        }
                    } while (location.trim().isEmpty());

                    System.out.printf("Nhập ngày tổ chức (dd/MM/yyyy): ");
                    Date date = null;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dateFormat.setLenient(false);
                    String dateEvent;
                    do {
                        dateEvent = scanner.nextLine();
                        try {
                            date = dateFormat.parse(dateEvent);
                        } catch (ParseException e) {
                            System.out.println("Ngày tổ chức phải viết theo định dạng dd/MM/yyyy");
                            System.out.printf("Nhập ngày tổ chức (dd/MM/yyyy): ");
                        }
                    } while (date == null);

                    System.out.printf("Nhập số lượng ghế (> 0): ");
                    Integer maxSeats;

                    do {
                        maxSeats = scanner.nextInt();
                        if (maxSeats <= 0) {
                            System.out.println("Số ghế phải lớn hơn 0");
                            System.out.printf("Nhập số lượng ghế (> 0): ");
                        }
                    } while (maxSeats <= 0);

                    eventBookingService.addEvent(new Event(eventId++, eventName, location, date, maxSeats));
                    System.out.println("Thêm sự kiện thành công");
                    break;

                case 2:
                    System.out.println("2. Hiển thị danh sách sự kiện");
                    eventBookingService.displayEvents();
                    break;

                case 3:
                    System.out.println("3. Hiển thị danh sách đặt vé");
                    eventBookingService.displayBookings();
                    break;

                case 4:
                    System.out.println("4. Tìm kiếm sự kiện theo tên");
                    eventBookingService.searchEventByName();
                    break;

                case 5:
                    System.out.println("5. Đặt vé");
                    String email;
                    System.out.printf("Nhập email: ");
                    do {
                        email = scanner.nextLine();
                        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                            System.out.println("Email không đúng định dạng");
                            System.out.printf("Nhập email: ");
                        }
                    } while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));

                    System.out.printf("Nhập id sự kiện: ");
                    int eventId1 = scanner.nextInt();

                    int seatNumber;
                    System.out.printf("Nhập số ghế: ");
                    do {
                        seatNumber = scanner.nextInt();
                        if (seatNumber <= 0) {
                            System.out.println("Số ghế phải lớn hơn 0");
                            System.out.printf("Nhập số ghế: ");
                        }
                    } while (seatNumber <= 0);

                    eventBookingService.bookTicket(email, eventId1, seatNumber);
                    break;

                case 6:
                    System.out.println("6. Thống kê lượt đặt vé theo sự kiện");
                    eventBookingService.displayStatistics();
                    break;

                case 7:
                    System.out.println("7. Thoát");
                    System.exit(0);

                default:
                    System.out.println("Không có chức năng này");
            }
        } while (true);
    }

}

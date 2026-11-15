import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;


public class HotelManagement {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Guest> guests = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Payment> payments = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();

    public HotelManagement() {
    initializeRooms();
    }

    // Start the hotel application
    public void start() {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("       GRAND HORIZON HOTEL");
            System.out.println("================================");
            System.out.println("1. Guest Management");
            System.out.println("2. Room Management");
            System.out.println("3. Booking Management");
            System.out.println("4. Payment Management");
            System.out.println("5. Employee Management");
            System.out.println("0. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    manageGuests();
                    break;

                case 2:
                    manageRooms();
                    break;

                case 3:
                    manageBookings();
                    break;

                case 4:
                    managePayments();
                    break;

                case 5:
                    manageEmployees();
                    break;

                case 0:
                    System.out.println("Thank you for visiting Grand Horizon Hotel!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }

    // Guest Management Menu
    private void manageGuests() {

        int choice;

        do {
            System.out.println("\n===== GUEST MANAGEMENT =====");
            System.out.println("1. Register New Guest");
            System.out.println("2. View All Guests");
            System.out.println("3. Search Guest by ID");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerGuest();
                    break;

                case 2:
                    viewAllGuests();
                    break;

                case 3:
                    searchGuest();
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }


    // Register a new guest
    private void registerGuest() {

        scanner.nextLine();

        System.out.println("\n===== REGISTER NEW GUEST =====");

        System.out.print("Enter Guest Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        String guestId = "G" + (guests.size() + 1);

        Guest guest = new Guest(name, phone, email, guestId);

        guests.add(guest);

        System.out.println("\nGuest registered successfully!");
        System.out.println("Guest ID: " + guestId);

        
    }
    


    
    // Display all registered guests
    private void viewAllGuests() {

        System.out.println("\n===== REGISTERED GUESTS =====");

        if (guests.isEmpty()) {
            System.out.println("No guests registered yet.");
            return;
        }

        for (Guest guest : guests) {
            System.out.println("----------------------------");
            guest.displayDetails();
        }

        System.out.println("----------------------------");
    }


    // Search for a guest using Guest ID
    private void searchGuest() {

        scanner.nextLine();

        System.out.print("\nEnter Guest ID: ");
        String searchId = scanner.nextLine();

        boolean found = false;

        for (Guest guest : guests) {

            if (guest.getGuestId().equalsIgnoreCase(searchId)) {

                System.out.println("\n===== GUEST FOUND =====");
                guest.displayDetails();

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Guest not found.");
        }
    }
    //crearing 50 rooms for the hotel with different categories and prices
    private void initializeRooms() {

    // Floor 1: 13 Standard Rooms
    for (int i = 101; i <= 113; i++) {
        rooms.add(new StandardRoom(i, 1));
    }

    // Floor 2: 12 Standard Rooms
    for (int i = 201; i <= 212; i++) {
        rooms.add(new StandardRoom(i, 2));
    }

    // Floor 3: 10 Deluxe Rooms
    for (int i = 301; i <= 310; i++) {
        rooms.add(new DeluxeRoom(i, 3));
    }

    // Floor 4: 10 Deluxe Rooms
    for (int i = 401; i <= 410; i++) {
        rooms.add(new DeluxeRoom(i, 4));
    }

    // Floor 5: 5 VIP Rooms
    for (int i = 501; i <= 505; i++) {
        rooms.add(new VIPRoom(i, 5));
    }

    System.out.println("50 hotel rooms initialized successfully!");
    }
    
    private void manageRooms() {

    int choice;

    do {
        System.out.println("\n===== ROOM MANAGEMENT =====");
        System.out.println("1. View All Rooms");
        System.out.println("2. Search Room by Number");
        System.out.println("0. Back to Main Menu");

        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                viewAllRooms();
                break;

            case 2:
                searchRoom();
                break;

            case 0:
                System.out.println("Returning to Main Menu...");
                break;

            default:
                System.out.println("Invalid choice!");
        }

    } while (choice != 0);
    }

    private void viewAllRooms() {

        System.out.println("\n========== GRAND HORIZON HOTEL: ROOM INVENTORY ==========");

        for (Room room : rooms) {
            System.out.println("----------------------------------------");
            room.displayRoomDetails();
        }

        System.out.println("----------------------------------------");
        System.out.println("Total Rooms: " + rooms.size());
    }

    private void searchRoom() {

        System.out.print("\nEnter Room Number: ");
        int searchNumber = scanner.nextInt();

        boolean found = false;

        for (Room room : rooms) {

            if (room.getRoomNumber() == searchNumber) {

                System.out.println("\n===== ROOM FOUND =====");
                room.displayRoomDetails();

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Room not found!");
        }
    }
    
    // Displays the Booking Management menu and handles user selections
    private void manageBookings() {

        int choice;

        do {
            System.out.println("\n==========================");
            System.out.println(".     BOOKING MANAGEMENT. ");
            System.out.println("\n==========================");
            System.out.println("1. Create New Booking");
            System.out.println("2. View All Bookings");
            System.out.println("3. Search Booking by ID");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createBooking();
                    break;

                case 2:
                    viewAllBookings();
                    break;

                case 3:
                    searchBooking();
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

        
private void createBooking() {

    System.out.println("\n===== CREATE NEW BOOKING =====");
    System.out.println("1. Standard Room - €650 per night");
    System.out.println("2. Deluxe Room - €900 per night");
    System.out.println("3. VIP Room - €1500 per night");

    System.out.print("Select Room Category: ");
    int category = scanner.nextInt();

    System.out.println("\n===== AVAILABLE ROOMS =====");

    boolean found = false;

    for (Room room : rooms) {

        boolean matchingCategory = false;

        if (category == 1 && room instanceof StandardRoom) {
            matchingCategory = true;
        } 
        else if (category == 2 && room instanceof DeluxeRoom) {
            matchingCategory = true;
        } 
        else if (category == 3 && room instanceof VIPRoom) {
            matchingCategory = true;
        }

        if (matchingCategory && room.isAvailable()) {

            System.out.println(
                "Room Number: " + room.getRoomNumber()
                + " | Floor: " + room.getFloorNumber()
                + " | Price: €" + room.getPricePerNight()
            );

            found = true;
        }
    }

    
        if (!found) {
            System.out.println("No available rooms in this category.");
            return;
        }

        // Ask receptionist to select a room
        System.out.print("\nEnter Room Number: ");
        int roomNumber = scanner.nextInt();

        Room selectedRoom = null;

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber
                    && room.isAvailable()) {

                if ((category == 1 && room instanceof StandardRoom)
                        || (category == 2 && room instanceof DeluxeRoom)
                        || (category == 3 && room instanceof VIPRoom)) {

                    selectedRoom = room;
                    break;
                }
            }
        }

        if (selectedRoom == null) {
            System.out.println("Invalid room selection or room unavailable.");
            return;
        }

        System.out.println("\nRoom " + selectedRoom.getRoomNumber()
                + " selected successfully!");


        // Collect customer details
        scanner.nextLine();

        System.out.println("\n===== CUSTOMER REGISTRATION =====");

        System.out.print("Enter Guest Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        // Generate Guest ID automatically
        String guestId = "G" + (guests.size() + 1);

        // Create and register the guest
        Guest selectedGuest = new Guest(name, phone, email, guestId);

        guests.add(selectedGuest);

        System.out.println("\nGuest registered successfully!");
        System.out.println("Guest ID: " + guestId);


        
        // Collect booking dates
        System.out.println("\n===== BOOKING DATES =====");

        System.out.print("Enter Check-in Date (YYYY-MM-DD): ");
        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter Check-out Date (YYYY-MM-DD): ");
        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

        // Validate booking dates
        if (!checkOutDate.isAfter(checkInDate)) {
            System.out.println("Invalid dates! Check-out must be after check-in.");
            guests.remove(selectedGuest);
            return;
        }

        // Calculate duration and price
        long numberOfNights = java.time.temporal.ChronoUnit.DAYS.between(
                checkInDate, checkOutDate);

        double totalPrice = numberOfNights * selectedRoom.getPricePerNight();

        // Display booking summary
        System.out.println("\n===== BOOKING SUMMARY =====");
        System.out.println("Guest: " + selectedGuest.getName());
        System.out.println("Room: " + selectedRoom.getRoomNumber());
        System.out.println("Check-in: " + checkInDate);
        System.out.println("Check-out: " + checkOutDate);
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.printf("Total Price: €%.2f%n", totalPrice);


        
        // Select payment method
        System.out.println("\n===== PAYMENT METHOD =====");
        System.out.println("1. Credit/Debit Card");
        System.out.println("2. Cash");
        System.out.println("3. Bank Transfer");
        System.out.println("4. Online Payment");

        System.out.print("Select Payment Method: ");
        int paymentChoice = scanner.nextInt();

        String paymentMethod;

        switch (paymentChoice) {
            case 1:
                paymentMethod = "Credit/Debit Card";
                break;

            case 2:
                paymentMethod = "Cash";
                break;

            case 3:
                paymentMethod = "Bank Transfer";
                break;

            case 4:
                paymentMethod = "Online Payment";
                break;

            default:
                System.out.println("Invalid payment method!");
                guests.remove(selectedGuest);
                return;
        }

        // Generate Booking ID
        String bookingId = "B" + (bookings.size() + 1);

        // Create booking object
        Booking booking = new Booking(
                bookingId,
                selectedGuest,
                selectedRoom,
                checkInDate,
                checkOutDate
        );

        // Save booking
        bookings.add(booking);

        // Mark room as occupied
        selectedRoom.setAvailable(false);

        // Generate Payment ID
        String paymentId = "P" + (payments.size() + 1);

        // Create payment record
        Payment payment = new Payment(
                paymentId,
                booking,
                paymentMethod
        );

        // Save payment
        payments.add(payment);
        booking.setPaymentStatus("Paid");

        // Display confirmation
        System.out.println("\nBooking confirmed successfully!");

        // Display booking confirmation
        System.out.println("\n========== BOOKING CONFIRMATION ==========");

        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Guest ID: " + selectedGuest.getGuestId());
        System.out.println("Guest Name: " + selectedGuest.getName());

        System.out.println("------------------------------------------");

        System.out.println("Room Number: " + selectedRoom.getRoomNumber());
        System.out.println("Room Type: " + selectedRoom.getRoomType());
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + checkOutDate);
        System.out.println("Number of Nights: " + numberOfNights);

        System.out.println("------------------------------------------");

        System.out.printf("Total Amount: €%.2f%n", totalPrice);
        System.out.println("Payment Method: " + payment.getPaymentMethod());
        System.out.println("Payment Status: " + payment.getPaymentStatus());
        System.out.println("Booking Status: " + booking.getBookingStatus());

        System.out.println("==========================================");
        System.out.println("Thank you for choosing Grand Horizon Hotel!");

    }

    // Display all hotel bookings
    private void viewAllBookings() {

        System.out.println("\n========== ALL BOOKINGS ==========");

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking booking : bookings) {
            booking.displayBookingDetails();
        }

        System.out.println("Total Bookings: " + bookings.size());
    }
    // Search for a booking using Booking ID
    private void searchBooking() {

        scanner.nextLine();

        System.out.print("\nEnter Booking ID: ");
        String searchId = scanner.nextLine();

        boolean found = false;

        for (Booking booking : bookings) {

            if (booking.getBookingId().equalsIgnoreCase(searchId)) {

                System.out.println("\n===== BOOKING FOUND =====");
                booking.displayBookingDetails();

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Booking not found!");
        }
    }




    // Payment Management Menu
    private void managePayments() {

        int choice;

        do {
            System.out.println("\n===== PAYMENT MANAGEMENT =====");
            System.out.println("1. View All Payments");
            System.out.println("2. Search by Payment ID");
            System.out.println("3. Search by Booking ID");
            System.out.println("4. Search by Room Number and Stay Dates");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    viewAllPayments();
                    break;

                case 2:
                    searchPaymentById();
                    break;

                case 3:
                    searchPaymentByBookingId();
                    break;

                case 4:
                    searchPaymentByRoomAndDates();
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
        }

        // Display all recorded payments
        private void viewAllPayments() {

            System.out.println("\n========== ALL PAYMENT RECORDS ==========");

            if (payments.isEmpty()) {
                System.out.println("No payment records found.");
                return;
            }

            for (Payment payment : payments) {
                payment.displayPaymentDetails();
            }

            System.out.println("------------------------------------------");
            System.out.println("Total Transactions: " + payments.size());
            }


            // Search for a payment using Payment ID
            private void searchPaymentById() {

                scanner.nextLine();

                System.out.print("\nEnter Payment ID: ");
                String searchId = scanner.nextLine();

                boolean found = false;

                for (Payment payment : payments) {

                    if (payment.getPaymentId().equalsIgnoreCase(searchId)) {

                        System.out.println("\n===== PAYMENT FOUND =====");
                        payment.displayPaymentDetails();

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Payment not found!");
                }
            }



            // Search payment using Booking ID
            private void searchPaymentByBookingId() {

                scanner.nextLine();

                System.out.print("\nEnter Booking ID: ");
                String searchId = scanner.nextLine();

                boolean found = false;

                for (Payment payment : payments) {

                    if (payment.getBooking().getBookingId().equalsIgnoreCase(searchId)) {

                        System.out.println("\n===== PAYMENT FOUND =====");
                        payment.displayPaymentDetails();

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No payment found for this booking!");
                }
            }

            // Search payment using Room Number and Stay Dates
            private void searchPaymentByRoomAndDates() {

                scanner.nextLine();

                System.out.print("\nEnter Room Number: ");
                int searchRoomNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Check-in Date (YYYY-MM-DD): ");
                LocalDate checkInDate = LocalDate.parse(scanner.nextLine());

                System.out.print("Enter Check-out Date (YYYY-MM-DD): ");
                LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

                boolean found = false;

                for (Payment payment : payments) {

                    Booking booking = payment.getBooking();

                    if (booking.getRoom().getRoomNumber() == searchRoomNumber
                            && booking.getCheckInDate().equals(checkInDate)
                            && booking.getCheckOutDate().equals(checkOutDate)) {

                        System.out.println("\n===== PAYMENT FOUND =====");
                        payment.displayPaymentDetails();

                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No payment found for this room and stay dates!");
                }
            }


            // Employee Management Menu
            private void manageEmployees() {

                int choice;

                do {
                    System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
                    System.out.println("1. Register New Employee");
                    System.out.println("2. View All Employees");
                    System.out.println("3. Search Employee by ID");
                    System.out.println("0. Back to Main Menu");

                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();

                    switch (choice) {

                        case 1:
                            registerEmployee();
                            break;

                        case 2:
                            viewAllEmployees();
                            break;

                        case 3:
                            searchEmployee();
                            break;

                        case 0:
                            System.out.println("Returning to Main Menu...");
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }

                } while (choice != 0);
            }


            // Register a new employee
            private void registerEmployee() {

                scanner.nextLine();

                System.out.println("\n===== REGISTER NEW EMPLOYEE =====");

                System.out.print("Enter Employee Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Phone Number: ");
                String phone = scanner.nextLine();

                System.out.print("Enter Email: ");
                String email = scanner.nextLine();

                System.out.print("Enter Position: ");
                String position = scanner.nextLine();

                System.out.print("Enter Monthly Salary (€): ");
                double salary = scanner.nextDouble();

                String employeeId = "E" + (employees.size() + 1);

                Employee employee = new Employee(
                        employeeId, name, phone, email, position, salary
                );

                employees.add(employee);

                System.out.println("\nEmployee registered successfully!");
                System.out.println("Employee ID: " + employeeId);
            }


            // View all employees
            private void viewAllEmployees() {

                System.out.println("\n========== ALL EMPLOYEES ==========");

                if (employees.isEmpty()) {
                    System.out.println("No employees found.");
                    return;
                }

                for (Employee employee : employees) {
                    employee.displayDetails();
                }

                System.out.println("\nTotal Employees: " + employees.size());
            }

            // Search employee by ID
            private void searchEmployee() {

                scanner.nextLine();

                System.out.print("\nEnter Employee ID: ");
                String searchId = scanner.nextLine();

                boolean found = false;

                for (Employee employee : employees) {

                    if (employee.getEmployeeId().equalsIgnoreCase(searchId)) {

                        System.out.println("\n===== EMPLOYEE FOUND =====");
                        employee.displayDetails();

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Employee not found!");
                }
            }



}

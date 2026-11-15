import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {
  
    private String bookingId;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private long numberOfNights;
    private double totalPrice;
    private String paymentStatus;
    private String bookingStatus;

    public Booking(String bookingId, Guest guest, Room room,
                   LocalDate checkInDate, LocalDate checkOutDate) {

        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

        this.numberOfNights = ChronoUnit.DAYS.between(
            checkInDate, checkOutDate
        );

        this.totalPrice = numberOfNights * room.getPricePerNight();

        this.paymentStatus = "Unpaid";
        this.bookingStatus = "Confirmed";
    }


    public String getBookingId() {
        return bookingId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public long getNumberOfNights() {
        return numberOfNights;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }


    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void displayBookingDetails() {

        System.out.println("\n========== BOOKING DETAILS ==========");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Guest ID: " + guest.getGuestId());
        System.out.println("Guest Name: " + guest.getName());
        System.out.println("Room Number: " + room.getRoomNumber());
        System.out.println("Room Type: " + room.getRoomType());
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + checkOutDate);
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.printf("Total Price: €%.2f%n", totalPrice);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Booking Status: " + bookingStatus);
        System.out.println("=====================================");
    }



}
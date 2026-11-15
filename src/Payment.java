
import java.time.LocalDate;

public class Payment {

    private String paymentId;
    private Booking booking;
    private String paymentMethod;
    private double amount;
    private LocalDate paymentDate;
    private String paymentStatus;

    public Payment(String paymentId, Booking booking,
                   String paymentMethod) {

        this.paymentId = paymentId;
        this.booking = booking;
        this.paymentMethod = paymentMethod;
        this.amount = booking.getTotalPrice();
        this.paymentDate = LocalDate.now();
        this.paymentStatus = "Paid";
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void displayPaymentDetails() {

        System.out.println("\n========== PAYMENT RECEIPT ==========");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Guest Name: " + booking.getGuest().getName());
        System.out.println("Guest ID: " + booking.getGuest().getGuestId());
        System.out.println("Room Number: " + booking.getRoom().getRoomNumber());
        System.out.println("Payment Method: " + paymentMethod);
        System.out.printf("Amount Paid: €%.2f%n", amount);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("=====================================");
    }
}

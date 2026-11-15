
public class Guest extends Person {

    private String guestId;

    // Constructor
    public Guest(String name, String phoneNumber,
                 String email, String guestId) {

        super(name, phoneNumber, email);
        this.guestId = guestId;
    }

    // Getter
    public String getGuestId() {
        return guestId;
    }

    // Method overriding
    @Override
    public void displayDetails() {
        System.out.println("Guest ID: " + guestId);
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
    }
}


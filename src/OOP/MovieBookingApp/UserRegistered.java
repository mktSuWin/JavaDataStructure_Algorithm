package OOP.MovieBookingApp;

import java.util.ArrayList;

public class UserRegistered extends User{
    private ArrayList<Ticket> bookingHistory;

    public UserRegistered(int id, String name, ArrayList<Ticket> bookingHistory) {
        super(id, name);
        this.bookingHistory = new ArrayList<>();
    }
}

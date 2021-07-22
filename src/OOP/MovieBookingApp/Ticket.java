package OOP.MovieBookingApp;

import java.util.Date;

public class Ticket {
    private int id;
    private String ownerName;
    private Date bookingTime;
    private int noOfSeats;
    // Create association
    private Show bookedShow;

    public Ticket(int id, String ownerName, Date bookingTime, int noOfSeats) {
        this.id = id;
        this.ownerName = ownerName;
        this.bookingTime = bookingTime;
        this.noOfSeats = noOfSeats;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Show getBookedShow() {
        return bookedShow;
    }

    public void setBookedShow(Show bookedShow) {
        this.bookedShow = bookedShow;
    }
}

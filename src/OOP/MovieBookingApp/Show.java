package OOP.MovieBookingApp;

import java.util.Date;

public class Show {
    private int id;
    private Date showTime;
    private int availableSeats;

    // Aggregation relationship
    // Therefore, make Movie as a member of show
    private Movie movie;
    // Bi-directional relationship
    private Theatre theatre;

    public Show(int id, Date showTime, Movie movie, Theatre theatre) {
        this.id = id;
        this.showTime = showTime;
        this.movie = movie;
        this.theatre = theatre;
        this.availableSeats = theatre.getCapacity();
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}

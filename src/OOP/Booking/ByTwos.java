package OOP.Booking;

public class ByTwos implements Series {
    int val;
    ByTwos(){
        this.val =0;
    }
    public int getNext(){
        val+=2;
        return val;
    }
}

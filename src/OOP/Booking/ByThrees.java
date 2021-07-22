package OOP.Booking;

public class ByThrees implements Series {
    int val;
    ByThrees(){
        this.val =0;
    }
    public int getNext(){
        val+=3;
        return val;
    }
}

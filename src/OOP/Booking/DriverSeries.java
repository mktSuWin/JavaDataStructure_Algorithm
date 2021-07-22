package OOP.Booking;

public class DriverSeries {
    public static void main(String[] args) {
        ByTwos byTwos = new ByTwos();
        for(int i = 0; i < 5; i++){
            System.out.println(byTwos.getNext());
        }

        Series ob;

        ByThrees byThrees = new ByThrees();
        for(int i =0; i < 5; i++){
            ob = byThrees;
            System.out.println( "byThrees" + byThrees.getNext());

            ob = byTwos;
            System.out.println( "byTwos" + byThrees.getNext());
        }
    }
}

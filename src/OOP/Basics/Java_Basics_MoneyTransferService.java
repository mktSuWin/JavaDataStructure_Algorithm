package OOP.Basics;

public class Java_Basics_MoneyTransferService {
    public static void main(String[] args) {
        int id = 100;
        updated(id);
        System.out.println(id);
        Student s1 = new Student();
        s1.id1 = 200;
        updatedStudentID(s1);
        System.out.println(s1.id1);
    }
    static void updated(int newID){
        newID = 101;
    }

    static void updatedStudentID(Student s1){
        s1.id1 = 1001;
    }



}
class MoneyTransferService {

    static double computerTransferFee(double countryIndex, int amount){
        return 0.1;
    }



}
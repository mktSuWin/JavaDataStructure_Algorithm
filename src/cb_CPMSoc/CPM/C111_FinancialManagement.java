package cb_CPMSoc.CPM;

import java.util.Scanner;

public class C111_FinancialManagement {
    public static void main(String[] args) {
        double average, sum = 0.0;
        int Months = 2;
        double[] array = new double[Months];
        for(int i = 0; i < Months; i++){
            Scanner sc = new Scanner(System.in);
            array[i] = sc.nextDouble();
            sum += array[i];
        }
        average = sum/Months;
        System.out.printf("$%.2f" , average);
    }
}

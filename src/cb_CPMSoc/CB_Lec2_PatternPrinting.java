package cb_CPMSoc;
import java.util.Scanner;

public class CB_Lec2_PatternPrinting {
    public static void main(String[] args) {
//        printPattern1();
        digitsExtraction();
    }
    //====================================================
    // Question 1: Pattern Printing
    //====================================================
    //0     1
    //1     01
    //2     101
    //3     0101
    //4     10101
    //====================================================
    // Odd row, always start with 1 and then alternate
    // i = row
    // j = num that we are currently printing in that row
    // if (i + j) -> even print 1, else 0;
    public static void printPattern1(){
        System.out.println("Enter number of lines: ");
        Scanner sc = new Scanner(System.in);
        int numOfLines = sc.nextInt();
        for (int row = 0; row < numOfLines; row++){
            for (int col = 0; col <= row; col++){
                // 0 + 0 = 0/2 = 0
                // 1 + 0 = 1/2 = 1
                if ((row + col)% 2== 0){
                    System.out.print("1");
                }else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    //====================================================
    // Question 2 : Find digits in a number?
    //====================================================
    public static void digitsExtraction(){
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int digit = sc.nextInt();

        while (digit > 0){
            int remainder = digit % 10;
            digit /= 10;
            System.out.println(remainder);
        }
    }

    //====================================================
    // Question 3 : Find digits in a number?
    //====================================================
}
















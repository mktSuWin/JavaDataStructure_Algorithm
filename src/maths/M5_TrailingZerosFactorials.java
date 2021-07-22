package maths;

import java.math.BigInteger;

public class M5_TrailingZerosFactorials {
    public static void main(String[] args) {
        int n = 5;
//        System.out.println(countTrailingZerosInFactorials(n));
//        System.out.println(countZeroes(n));
//        System.out.println(countTrailingZerosInFactorials_BigInt(n));
//        System.out.println(countTrailingZerosInFactorials_Efficient(n));
        System.out.println(countZeroes(n));

    }

    // Recursive way
    //-----------------------------------------------
    public static int countTrailingZerosInFactorials_Recursive(int n){
        int fact =  1;
        if ( n == 0) return fact;
        return n * countTrailingZerosInFactorials_Recursive(n- fact);
    }

    public static int countZeroes(int n){
        int count = 0;
        int factorialRecursive = countTrailingZerosInFactorials_Recursive(n);
        while (factorialRecursive % 10 == 0){
            count++;
            factorialRecursive /= 10;
        }
        return count;
    }

    // Iterative using BigInteger
    public static int countTrailingZerosInFactorials_BigInt(int n){
        //Calculate for n! factorial
        BigInteger fact = BigInteger.ONE;
        for(int i = 2; i <= n; i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        int count = 0;
        while (fact.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
            fact = fact.divide(BigInteger.TEN);
            count++;
        }
        return count;
    }
//-----------------------------------------------------------------
    /*
    16
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
            ^          ^              ^
            0          0              0
     n = 5
     count = 0
     i = 5
     currFact = 5
     5 % 5 == 0 , true
     count = 1
     currentFact = 5/5 = 1

     i = 10
     10 <= 5 (NO), therefore break out from for loop

          */
    // Time O(n)

    public static int trailingZeroes_FiveOptimisation(int n){
        int count = 0;
        for (int i = 5; i <= n; i+=5){
            int currFact = i;
            while (n % 5 == 0){
                count++;
                currFact /= 5;
            }
        }
        return count;
    }
//-----------------------------------------------------------------
    // Time Theta O(n)
    // Space O(1)
    // n = 20, there will be overflow. 19 digits
    // Overflow issue
    public static int countTrailingZerosInFactorials(int n){
        int fact = 1;
        for(int i = 2; i <= n; i++){
            fact *= i;
        }
        int result = 0;
        while (fact % 10 == 0){
            result++;
            fact /= 10;
        }
        return result;
    }

    // Prime factorisation
    // How many 2 x 5, 10 you have in the number
    // How many 5 and 10 you have in the factorisation
    // Prime factorisation of 5
    // trailing zero count = [n/5] + [n/25] + [n/125]
    // Theta
    public static int countTrailingZerosInFactorials_Efficient(int n){
        int result = 0;
        for(int i = 5; i <= n; i *= 5){// result = 0 + 100/5 = 20
            result += (n/i);           // result = 20 + 100 / 25 (4) = 24
        }                              // result = 24 + 100 / 125 , 125 !<= 100
        return result;
    }
    // n = 10
    // count = 0
    // currentMultiple = 5
    // 10 > 5
    // count = 0 + 10/5 (2) = 2
    // currentMultiple = 5 * 5 = 25

    // 10 >= 15 not true, therefore return count
    // Therefore Time O(log n)
    // fives = n/5 + (n/5)/5 + ((n/5)/5)/ 5 + ...
    // Space O(1)
    public static int countTrailingZeros_Optimised(int n){
        int count = 0;
        long currentMultiple = 5;
        while (n >= currentMultiple){
            count += n/currentMultiple;
            currentMultiple *= 5;
        }
        return count;
    }

    public static int countTrailingZeroes_Iterative(int n){
        int count = 0;
        for(int i = 5; i <=n; i+=5){
            int powerof5 = 5;
            while (i % powerof5 == 0){
                count++;
                powerof5 *= 5;
            }
        }
        return count;
    }
}


/*
        Time O(n)
        n= 10
        count = 0
        i = 5
        fact = i = 5
        5 % 5 == 0
        count = 1
        fact = 5/5 = 1
        ---------------
        i = 10
        n = 10
        fact = 10
        count = 2
        fact = 10/5 = 2
        2 % 5 != 0
        theefore , break out from while loop
        i = 15

        public static int trailingZeroes(int n){
            int count = 0;
            for(int i = 5; i <= n; i+=5){
                int fact = i;
                while (fact % 5 == 0){
                    count++;
                    fact /= 5;
                }
            }
            return count;
        }


        123 * 10 = 1230
        120 * 10 = 1210
        1   2   3   4   5   6   7   8   9   10
            ^           ^                   ^
        5! = one trailing zero
        10! =  two trailing zeros
        More 2 than 5 in 1 to 10
        2 will multiply with 5.
        Therefore count only 5

        n = 25
        5   10  15  20  25
        5   5   5   5   5
        25/5 = 5
        25/ (5 * 5) = 1
        Total = 5 + 1


        100
        // Comparison +=5
        5   10  15  20  25  30  35  40  45  50  55  60  65  70  75  80  85  90  95  100
        1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20
        20


        // *= 5
        100/5 = 20
        100/25 = 4
        100/ 125 = 0

        // 125
        125/5 + 125/25 + 125/125 + 125/625
        25    + 5       + 1       + 0 = 31


 */
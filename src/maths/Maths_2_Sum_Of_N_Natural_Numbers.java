package maths;

import java.util.Scanner;
/*
Find the total money saved after n days.
    n = 3
    1 + 2 + 3 = 6

 */
public class Maths_2_Sum_Of_N_Natural_Numbers {
    public static void main(String[] args) {
        int numOfDays = 3;
        System.out.println(totalMoneySavedAfterNDays(numOfDays));
        System.out.println(totalMoneySaved_ArithmeticProgression(numOfDays));
    }

    // Naive solution
    // Theta Time O(n)
    // Space (0)
    public static int totalMoneySavedAfterNDays(int numOfDays){
        int totalMoney = 0;
        for(int i = 0; i <= numOfDays; i++){
            totalMoney += i;
        }
        return totalMoney;
    }

    // Optimised Efficient Solution
    // Arithmetic progression
    // first term a = 1
    // common difference d = 1
    // 1    2    3
    // a    a+d  a+2d
    // xn = a + d (n-1)
    //    1    1
    // d = 1
    // Sum of n terms = n/2 [2a + (n-1)d]
    //                = n/2 [2x1 + (n-1)1
    //                = n x (n+1)/2
    // Theta(1) Time
    // Theta(1) Space
    public static int totalMoneySaved_ArithmeticProgression(int numberOfDays){
        return (numberOfDays * (numberOfDays+1)) / 2;
    }
}

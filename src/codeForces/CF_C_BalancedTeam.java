package codeForces;
// https://codeforces.com/problemset/problem/1133/C

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class CF_C_BalancedTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] nStudents = new Integer[n];
        for(int i = 0; i < n; i++){
            nStudents[i] = sc.nextInt();
        }
        Arrays.sort(nStudents);// n log n
        int count = 0;
        int p1 = 0;
        int p2 = 0;
        while ( p2 < nStudents.length){ // p2 < nStudents.length to prevent ArrayIndexOutOfBound error
            if (nStudents[p2] - nStudents[p1] <= 5){
                count = Math.max(count, p2-p1+1);
                p2++;
            } else{
                p1++;
            }
        }
        System.out.println(count);
    }
}

/*

 */

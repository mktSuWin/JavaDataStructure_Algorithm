package codeForces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// https://codeforces.com/problemset/problem/455/A
/*
    0   1   2   3   4   5   6   7   8 - index
    1   2   1   3   2   2   2   2   3 - numbers
        i -> (i-1) , (i+1)

    0   1   2   3   4   5   6   7   8 - index
        2   5   2
    max
    Bottom up approach
    ------------------

    If you select, 1, you cannot select 1.
    1 x 2 = 2
    2 x 5  = 10
    3 x 2 = 6

    max(2x1 + 3x2, 2x5);
    max(i) = max (dp[i-1], i*countI + dp[i-2])

 */
public class CF_A_Boredom_455 {
    public static void main(String[] args) {
        int max = 100002;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] countArray = new int[max];
        int[] dp = new int[10005];

        for(int i = 0; i < n; i++){
            countArray[sc.nextInt()]++;
        }
        dp[0] = 0;
        dp[1] = countArray[1];
        for(int i = 2; i <= max; i++ ){
            dp[i] = Math.max(dp[i-1], dp[i-2]+ countArray[i]*i);
        }
        System.out.println(dp[max-1]);
    }
}

/*
9
1 2 1 3 2 2 2 2 3
HashTable
1   2
2   5
3   2
Example 2
1   1   2   2   3   3
1   2
2   2
3   2
f(0) = 0
f(1) = count(1)
f(2) =
f(n) = max(

 */


// 1 2 1 3 2 2 2 2 3
// 1 1 2 2 2 2 2 3 3 4 4 5 5 5
// Key Value
// 1    2 = 2
// 2    5 = 10, picked
// 3    2 = 6 + 2 or 10
// 4    2 = 8 + 10 = 18 or 10,
// 5    3 = 15      15 + 10 = 25 or 18
// max of two numbers before,
// 1 1 2    2   2   3   3   4   4   4   5   5   5   5
// Key      Value
//====================
// 1        2 = 2 // First Step , you always pick 2, max = 2
// 2        3 = 6 // Now you have got options. 1 1 or 2 2 2
// picked = 2 2 2
// 3        2 = 6 // Option 1: 1 1 3 3 step(i-2) + 3
// Option 2: 2 2 2   step(i-1)
// (1133) or (222)
// 4        3 = 12 // step(i-2) + 4s (22244) or (1133)
// 5        4 = 20 // step(i-2) + 5s (11335555) or step (i-1) (22244)
// rec(i) = Math.max(rec(i-1), rec(i-2) + i * occurrences);
        /*
        Use HashMap to store key and occurrences
        Use Map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(input[i], map.getOrDefault(i,0)+1);
        }
         */

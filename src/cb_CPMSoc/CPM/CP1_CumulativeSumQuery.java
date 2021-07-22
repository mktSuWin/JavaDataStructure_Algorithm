package cb_CPMSoc.CPM;

import java.util.Scanner;

// Time O(n)
// O(n) + O( Q x (j - i + 1))
// O(10^5) + O(10^4) -> It could lead to
// O(10^5) + O(10^4 x 10^4)
// 10^5 size
// 0 ..................10^5-1
// 10^8 -> 1 second (server like codeforces is very fast) depending on the load of the server
// Brute force approach will give TLE function
public class CP1_CumulativeSumQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Array O(n)
        for (int i = 0; i < N; i++){
            int Q = sc.nextInt();
            while (Q > 0){ // O(q)
                int left = sc.nextInt();
                int right = sc.nextInt();

                Q--;
            }
        }
    }
}

/*
Pre-computation
---------------
// Time O(n) + O(n) + O(q)
        10^5 + 10^5 + 10^4 => It is within the time limit
Prefix sum will do pre-computation
Then I will answer all sorts of queries
array = { 2, 4, 3, 1, 5, 6}
    copy the first element
    preFixSum[3] = sum of sum [0-3]
    preFumSum summation
                            0   1   2   3   4   5
prefixSum = similar size {  2,  6,  9,  10, 15, 21} // O(n)
pseudocode
prefixSum size [n]
for (int i = 0 -> n-1) // O(n)
    if (i == 0) prefixSum[i] = array[i]
    else prefixSum[i] = prefix[i-1] + array[i]
precomputed
After this, I have to run queries

preFix[left, right] = prefix[right] - prefix[left -1]
prefix[2, 4] = prefix[4] - prefix[1] => only left is greater than 0

while (Q--) // O(1) constant operation
    { (left, right]
    sum = prefix

 */

/*
Given an array.
5
0   1   2   3   4   Index
1   3   5   4   7   Values
3
1   3   2 Go to 1 to 3 and increase the value to + 2
2   4   1
0   3   3

n <= 10^5
0<= 10^5
0 < L <= R < n
0 <= x <= 10^4

 */
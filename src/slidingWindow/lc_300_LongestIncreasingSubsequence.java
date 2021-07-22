package slidingWindow;
/*
Longest Non-decreasing subsequence
-1  3   4   5   2   2   2   2

    1. Generate all 2^n subsets
    Validate NDS property. Take the longest of that set. O(2^n) at least

    2. Dynamic Programming - subproblems O(n^2)

    3. O(n* log n) solution

    How to cut into subproblems
    -1  3   4   5   2   2   2   2
    -1
    -1  3
    -1  3   4
    -1  3   4   5
    -1  3   4   5   2
    -1  3   4   5   2   2
    -1  3   4   5   2   2   2
    -1  3   4   5   2   2   2   2
    answer + 1

    i   j
    is j >= i
    -1  3   4   5   2   2   2   2
    1   1   1   1   1   1   1   1

 */
public class lc_300_LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }
}

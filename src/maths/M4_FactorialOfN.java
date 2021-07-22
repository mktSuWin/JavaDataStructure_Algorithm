package maths;

public class M4_FactorialOfN {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorialOfN_Iterative(n));
    }

    // Theta O(n)
    // Space O(1)
    // Iterative Appraoch
    public static int factorialOfN_Iterative(int n){
        int total = 1;
        for(int i = 1; i <= n; i++){
            total *= i;
        }
        return total;
    }

    // Recursive approach
    // T(n) = T(n-1) + Q(1)
    // n + 1 level
    // Time Theta (n)
    // Space Theta (n)
    // 5 * fact(4) 5 * 24 = 120
    //      4 * fact(3) 4 * 6 = 24
    //          3 * fact(2) 3 * 2 = 6
    //              2 * fact(1) // 2 X 1 = 2
    //                  1 * fact(0) // 1 x 1 = 1
    //
    public static int factorialOfN_Recursive(int n){
        if (n == 0) return 1;
        return n * factorialOfN_Recursive(n-1);
    }
}

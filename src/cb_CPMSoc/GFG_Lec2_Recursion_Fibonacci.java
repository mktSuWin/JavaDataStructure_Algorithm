package cb_CPMSoc;

import java.util.Arrays;

public class GFG_Lec2_Recursion_Fibonacci {
    static long[] memory = new long[21];
    public static void main(String[] args) {
        Arrays.fill(memory, -1);
//        System.out.println(fibonacciIterative(7));
//        System.out.println(fibonacciRecursive(7));
        for(int i =0; i <= 20; i++){
            System.out.println(i + "th term = " + fibonacciMemoisation(i));
        }

//        System.out.println(fibonacciMemoisation(5));
        System.out.println(Arrays.toString(memory));


    }
    /*
    0   1   2   3   4   5   6   7   8
    0   1   1   2   3   5   8   13  21
    You use it when you have recurrence relation
    fibo(n) = fibo(n-1) + fibo(n-2)

     */
    public static int fibonacciIterative(int n){
        int a = 0;
        int b = 1;
        int c = a + b;
        for(int i = 2; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static int fibonacciRecursive(int n ){
        // Base case
        if (n == 0 ) return 0;
        if (n == 1) return 1;
        return fibonacciRecursive(n-1)+ fibonacciRecursive(n-2);
    }
    // Time O(n)
    public static long fibonacciMemoisation(int n){
        if (memory[n] != -1){
            return memory[n];
        } else if (n == 0 ) {
            memory[n] = 0;
            return 0;
        }
        else if (n == 1) {
            memory[n] = 1;
            return 1;
        }
        else{
            // Optimisation part
            long num = fibonacciMemoisation(n-1) + fibonacciMemoisation(n-2) ; // tribonacci number - fibonacciMemoisation(n-3)
            memory[n] = num;
            return num;
        }
    }

    /*
    Time 2^n - Recursive
    =========================
    fib(n) = fib(n-1) + fib(n-2)

    fib(5) = fib(4) + fib(3) 3 + 2 = 5
            /    \
          fib(3) fib(2) 2 + 1 = 3
         /  \
    fib(2) fib(1) 1 + 1 = 2
    /   \
 fib(1) fib(0) 1 + 0 = 1


     Fibonacci - Optimised
    =========================
      0  1  2  3
    [-1 -1 -1 -1]
    fib(3) = fib(2) + fib(1)
    fib(2) = fib(1) + fib(0)
                1   +  0 = 1

     */
}

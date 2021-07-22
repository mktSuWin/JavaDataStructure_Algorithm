package dynamicProgramming;

public class DP2_Fibonacci {
    static int n = 4;
    static int[] fibArray = new int[n+1];
    public static void main(String[] args) {

//        System.out.println(fibonacciRecursive(n));
        long startTime = System.nanoTime();
//        System.out.println(fibonacciDP_Memoisation(n)) ; //160300
        System.out.println(fibonacciDP_Tabulisation(n));   //246400
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);


    }

    public static int fibonacciRecursive(int n){
        if (n == 0 || n == 1) return 1;
        else
            return fibonacciRecursive(n-1)+ fibonacciRecursive(n-2);
    }
    /*
        n = 5
                         0  1  2  3  4  5
       int[] fibArray = {0, 0, 0, 0, 0, 0}
       fibArray[5] = 0
       fibArray[5] = fibDP(4) + fib(3);
                      fibArray[4] = fibDP(3) + fib

     */
    // Memorisation Approach
    // Time O()
    // Space O(n) - fibArray
    public static int fibonacciDP_Memoisation(int n){
        if (n == 0 || n == 1) return 1;
        if (fibArray[n] != 0){
            return fibArray[n];
        } else {
           return fibArray[n] = fibonacciDP_Memoisation(n-1)+ fibonacciDP_Memoisation(n-2);
        }
    }
    // Bottom up approach
    public static int fibonacciDP_Tabulisation(int n){

        if(n == 0 || n ==1) return 1;
        fibArray[0] = 1;
        fibArray[1] = 1;
        for(int i = 2; i < n; i++){
            fibArray[i] = fibArray[i-1]+ fibArray[i-2];
        }
        return fibArray[n-1];
    }
}

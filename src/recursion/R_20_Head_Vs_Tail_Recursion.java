package recursion;

public class R_20_Head_Vs_Tail_Recursion {
    public static void main(String[] args) {
//        headRecursion(5);
//        tailRecursion(5);
        System.out.println(headFactorial(4));
        System.out.println(tailFactorial(4));
    }

    public static void headRecursion(int n){
        System.out.println("Calling the function with n = " + n); // backtracking phase
        if (n==0) return;
        // call the method recursively
        headRecursion(n-1);
        // we do some operations
        System.out.println("The value n is : " + n);
        // Java call this method with value 5
        // 4
        // 3
        // 2
        // 1
        // 0 -- base case, therefore return 1
    }
    // You don't have to backtrack in this tail recursion
    public static void tailRecursion(int n){
        System.out.println("Calling the function with n = " + n);
        if (n==0) return;
        System.out.println("The value n is : "+ n);
        tailRecursion(n-1);
    }
    // 4 => 4 * 3 * 2 * 1 = 24// 1! = 1
    // depends heavily on each stack call
    // 3! depends on 2! depends on 1!
    public static int headFactorial(int n){
        if (n == 1) return 1;
        // First call the method recursively
        // n! = n * (n-1)!
        int res = headFactorial(n-1);
        // Do some operation
        int result = n * res;
        return result;
    }

    public static int tailFactorial(int n){
        if(n == 1) return 1;
        return n * tailFactorial(n-1);
    }
}

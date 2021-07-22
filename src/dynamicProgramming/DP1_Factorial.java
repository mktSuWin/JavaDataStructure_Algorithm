package dynamicProgramming;

public class DP1_Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }

    public static int factorial(int n){
        if (n == 0 || n ==1)return 1;
        else return n*(factorial(n-1));
    }
    // Incorrect -
    public static int factorialDP(int n){
        int[] factArray = new int[n+1];
        factArray[0] =1;
        for(int i = 1; i <= n; i++){
            factArray[i] = i* factArray[i-1];
        }
        return n;
    }
}

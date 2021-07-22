package cb_CPMSoc;

public class GFG_Lec2_Recursion_Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorialIterative(n));
//        System.out.println(factorialRecursive(n));
        for(int i = 0; i <= 5; i++){
            System.out.println(i + "! is " + factorialRecursive(i));
        }

    }

    public static int factorialIterative(int n){
        int fact = 1;
        for(int i = 1; i <=n; i++ ){
            fact *= i;
        }
        return fact;
    }

    public static int factorialRecursive(int n){
        if (n <=1) return 1;
        return n * factorialRecursive(n-1);
    }
}

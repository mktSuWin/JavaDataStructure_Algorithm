package recursion;

public class R_19_SumOfN {
    public static void main(String[] args) {
        System.out.println(sumIterative(4)); // 4 + 3 + 2 + 1
        System.out.println(sumRecursive(4));
    }

    private static int sumIterative(int n){
        int result = 0;
        for(int i = 1; i <= n; i++){
            result += i;
        }
        return result;
    }

    private static int sumRecursive(int n){
        if (n == 1) return 1;
        int result = 0;
        return n + sumRecursive(n-1);
    }
}

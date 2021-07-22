package cb_CPMSoc;
// https://leetcode.com/problems/fibonacci-number/
public class CB_Lec4_FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(8));
    }

    public static int fib(int n){
        if (n <= 1) return n;
        if (n == 2) return 1;
        int curr =0;
        int next = 1;
        for(int i = 2; i <=n; i++){
            int temp = curr;
            curr = next;
            next = curr + temp;
        }
        return next;
    }
}

package maths;

public class M3_SumOfSquares {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(sumOfSquares(n));
        System.out.println(sumOfSquares_Efficient(n));
    }


    // Time Theta (n)
    // Space O(1)
    public static int sumOfSquares(int n){
        int totalSum = 0;
        for(int i = 1; i <=n;i++){
            totalSum += i*i;
        }
        return totalSum;
    }

    //  sum of squares = n(n + 1) (2n + 1)/ 6
    public static int sumOfSquares_Efficient(int n){
        return (n * (n+1) * (2*n + 1))/6;
    }
}

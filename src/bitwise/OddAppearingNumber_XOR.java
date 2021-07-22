package bitwise;

import java.sql.PreparedStatement;

public class OddAppearingNumber_XOR {
    public static void main(String[] args) {
        int[] arr = {4, 3, 4, 4, 4, 5, 5, 5};
        int n = arr.length;
//        System.out.println(findOddAppearingNumber(arr, n));
        System.out.println(findOddAppearingNumber_NaiveSolution(arr));
    }

    static int findOddAppearingNumber_NaiveSolution(int[] arr){

        for(int i = 0; i < arr.length; i++){
            int result = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    result++;
                }
            }
            if(result % 2 != 0){
                return arr[i];
            }
        }

        return 0;
    }

    static int findOddAppearingNumber(int[] arr, int n){
        int result =0;
        for(int i = 0; i < n; i++){
            result = result ^ arr[i];
        }
        return result;
    }

    static int findMissingNumber(int[] arr){
        int missingNumber = 0;
        for(int i = 0; i < arr.length; i++){
            missingNumber = missingNumber ^ arr[i];
        }
        return missingNumber;
    }
}

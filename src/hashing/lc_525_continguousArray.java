package hashing;

import java.util.HashMap;
import java.util.Map;

public class lc_525_continguousArray {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 1, 1, 0, 1, 0, 0};
        System.out.println(findMaxLength(nums));

    }
/*
 1  0   0   0   1   1   0   1   0   0

        -------------  4
                    ------------- 4
                --------------------- 6
 ----------------------------- 8

    1   5   3   6
    PrefixSum Technique : Keep adding the previous element to the current element
    1   6   9   15
    Maintain prefixSum of the count
    If nums[i] is 1, add 1 to the count
    If nums[i] is 0, subtract 1 from the count

    1   0   0   0    1   1    0   1    0   0 <= Original nums array
    1   0   -1  -2  -1   0   -1   0   -1  -2 <= After applying prefix sum technique


    0   1   2   3    4   5    6   7    8   9 <= Index
    1   0   0   0    1   1    0   1    0   0 <= Given binary integer array
    1   -1  -1  -1   1   1    -1  1   -1  -1 <= replace all 1 with +1, all 0 with -1
    1   0   -1  -2   -1  0    -1  0   -1  -2


 */
    public static int findMaxLength(int[] nums){
        // Prepare prefix Sum array
        int[] preFixSumArray = new int[nums.length];
        for(int i =0; i < nums.length; i++){
            if (nums[i] == 1){
                preFixSumArray[i] = +1;
            } else {
                preFixSumArray[i] = -1;
            }
            if (i > 0){
                preFixSumArray[i] += preFixSumArray[i-1];
            }
        }

        for(int i : preFixSumArray){
            System.out.print(i + " ");
        }
        /*
            1   0   -1  -2   -1  0    -1  0   -1  -2 <= preFixSumArray
            Key    Value
            -----------
            1       0
            0       0
            -1

         */
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i =0; i < nums.length; i++){
            int preSum = preFixSumArray[i];
            if (map.containsKey(preSum)){
                int currLen = map.get(preSum);
                max = Math.max(max, currLen);
            } else{
                map.put(preSum, i);
            }
        }

        return max;
    }
}

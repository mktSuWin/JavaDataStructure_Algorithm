package bitwise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OddOccurrencesInUnSortedArray {


    public static void main(String[] args) {
        int[] nums= {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};
        oddOccurrencesInUnsortedArray(nums);
    }

    public static int[] oddOccurrencesInUnsortedArray(int[] nums){
        int n = nums.length;
        // Find the total exclusive OR value
        // from all the elements of the given nums array
        int netXOR =0;
        for(int i =0; i < n; i++){
            netXOR ^= nums[i];
        }

        // Check for ith bit to see whether it is set or not
        int setBitPosition = 0;
        while (true){
            if ((netXOR & 1) ==1){
                break;
            }
            // Then right shift for the next ith bit
            netXOR >>= 1;
            setBitPosition++;
        }
        /*
        // ArrayList Approach
        //Separate into two sets using ArrayList, not HashSet
        // The reason is there are repeating elements.
        // However this will take
        List<Integer> set1 = new ArrayList<>(), set2 = new ArrayList<>();
        // If element bit 1, put it into set1, otherwise it goes into set2.
        for(int i =0; i < nums.length; i++){
            // shift the number by setBitPosition
            // insert them into each subarray
            int temp = nums[i] >> setBitPosition;
            if ((temp & 1) == 1){
                set1.add(nums[i]);
            } else {
                set2.add(nums[i]);
            }
        }

        // XOR elements in set1 and set2
        int answer1 = 0;
        for(int i : set1){
            answer1 ^= i;
        }
        int answer2 =0;
        int[] result = new int[2];
        for(int i : set2){
            answer2 ^= i;
        }
        result[0] = answer1;
        result[1] = answer2;
        */

        // Instead of storing into ArrayList, XOR with nums[i]
        // Optimise space complexity
        int answer1 = 0, answer2= 0;
        int[] result = new int[2];
        for(int i = 0; i < n; i++){
            int temp = nums[i] >> setBitPosition;
            if ((temp & 1)== 1){
                answer1 ^= nums[i];
            } else {
                answer2 ^= nums[i];
            }
        }
        result[0] = answer1;
        result[1] = answer2;

        return result;
    }
}

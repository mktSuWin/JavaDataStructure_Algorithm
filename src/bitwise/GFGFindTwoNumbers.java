package bitwise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
001111 =15
Divide array into two subarrays

100010 -> ans1
101101 -> ans2

set 1-> contains all elements with 2nd bit =1 --> contains answer2
set 2-> contains all elements with 2nd bit =0 --> contains answer1
 */
public class GFGFindTwoNumbers {
    public static void main(String[] args) {
        int[] nums = new int[] {12, 23, 34, 12, 12, 23, 12, 45};
        twoOddOccurrenesInUnsortedArray(nums);
    }
    public static int[] twoOddOccurrenesInUnsortedArray(int[] nums){
        int n = nums.length;
        int totalXor =0;
        for(int i =0; i < n; i++){
            totalXor ^= nums[i];
        }
        int position = 0;
        while( true){
            if ((totalXor & 1) == 1){
                break;
            }
            totalXor >>=1;
            position++;
        }


        int ans1 = 0, ans2 = 0;
       // List<Integer> set1 = new ArrayList<>(), set2 = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int temp = nums[i] >> position;
            if ((temp & 1)==1){
                // set1.add(nums[i]);
                ans1 ^= nums[i];

            } else{
                //set2.add(nums[i]);
                ans2 ^= nums[i];
            }
        }

        /*
        for(int itr: set1){
            ans1 ^= itr;
        }

        for(int itr: set2){
            ans2 ^= itr;
        }
        */


        int[] result = new int[2];
        result[0] = ans1;
        result[2] = ans2;
        return result;

    }
}

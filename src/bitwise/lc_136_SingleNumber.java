package bitwise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc_136_SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        int result = 0;
        for(int i : nums){
            result ^= i;
        }
        return result;
    }

    public static int singleNumber1(int[] nums){
        int result =0;
        for(int i =0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }

    public static int singleNumber2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if (set.contains(i)){
                set.remove(i);
                continue;
            }
            set.add(i);
        }
        // There is only element in this HashSet. Below is how you get it out.
        return set.toArray(new Integer[1])[0];
    }

    public int singleNumber3(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
       // Add elements and their frequencies into map
       for(int i : nums){
           map.put(i, map.getOrDefault(i, 0)+1);
       }
       // Iterate through nums and map, and get element whose map value is 1.
        for(int i : nums){
            if (map.get(i) == 1){
                return i;
            }
        }
        return 0;
    }

    public int singleNumber4(int[] nums) {
        int sum =0;
        for(int i : nums){
            sum +=i;
        }

        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int y = 0;
        for(int i : set){
            y += i;
        }
        return 2*y - sum;
    }
}

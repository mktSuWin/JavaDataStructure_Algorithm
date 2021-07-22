package array;

import java.util.HashMap;
import java.util.Map;

public class lc_1_TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                result[0] = map.get(complement);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for(int i =0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[j] == target - nums[i]){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}

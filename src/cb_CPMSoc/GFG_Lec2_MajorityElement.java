package cb_CPMSoc;

import java.util.HashMap;

public class GFG_Lec2_MajorityElement {
    public static void main(String[] args) {
        int[] nums =  { 3, 2, 3, 2, 3 };
        System.out.println(majorityElements(nums));
        System.out.println(majorityElements_BoyerMooreVotingAlgorithm(nums));
    }

    public static int majorityElements(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        int key = nums[0];
        for(int a : map.keySet()){
            // if (map.get(a) > map.get(key)){

            if (map.get(a) > n/2 +1){
                key = a;
            }
        }
        return key;
    }

    // if
    // major_element
    // count = 1
    // whenever count -1
    // modify current element to ith element
    public static int majorityElements_BoyerMooreVotingAlgorithm(int[] nums){
        int n = nums.length;
        int majority = nums[0], count = 1;
        for(int i = 0; i < nums.length; i++){
            if (count == 0){
                count++;
                majority = nums[i];
            } else if (majority == nums[i]){
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    public static int majorityElements_Optimised(int[] nums){
        int n = nums.length;
        int majority = nums[0];
        int count = 1;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == majority){
                count++;
            } else {
                count--;
            }
            if (count < 0){
                count = 1;
                majority = nums[i];
            }
        }
        return majority;
    }
}

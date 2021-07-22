package cb_CPMSoc;
/*
https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 */
public class GFG_Lec2_max_difference_Between_TwoElements {
    public static void main(String[] args) {
        int[] nums =  {2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxDifferenceOptimised(nums));
    }
    // {2, 3, 10, 6, 4, 8, 1}
    public static int maxDifference(int[] nums){
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[j] - nums[i] > max){
                    max = (nums[j] - nums[i]);
                }
            }
        }
        return max;
    }
/*

int n = a.size();
        int maxTillNow = a.get(n-1);
        result.add(a.get(n-1));
        for(int i = n-2;i >= 0; i++){
            if (a.get(i) > maxTillNow){
                maxTillNow = a.get(i);
                result.add(a.get(i));
            }
        }
        return result;
 */
    public static int maxDifferenceOptimised(int[] nums) {
        int maxRight = nums[nums.length-1];
        int maxDiff = 0;
        for(int i = nums.length-2; i >=0; i--){
            if (nums[i] > maxRight){
                maxRight = nums[i];
            } else{
                int currDiff = maxRight - nums[i];
                maxDiff = Math.max(currDiff, maxDiff);
            }
        }
        return maxDiff;

    }
}

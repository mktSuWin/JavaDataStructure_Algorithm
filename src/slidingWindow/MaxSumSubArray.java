package slidingWindow;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        int k = 3;
        System.out.println(findMaxSumSubArray(nums, k));
    }
    /*
        0   1   2   3   4   5   6   7   8   9 <= Index
        4   2,  1,  7,  8,  1,  2,  8,  1,  0 <= nums array
                                              <= k = 3
        4   6   7   When i = 2 >= 3 -1 = 2, max = 7, curSum -= nums[2 - (3-1)]


     */
    public static int findMaxSumSubArray(int[] nums, int k){
        int max = Integer.MIN_VALUE;
        int currRunningSum = 0;
        for(int i = 0; i < nums.length; i++){
            currRunningSum += nums[i];
            if (i >= k-1){
                max = Math.max(currRunningSum, max);
                currRunningSum -= nums[i-(k-1)]; // remove the left most element from previous window
            }
        }
        return max;
    }
}

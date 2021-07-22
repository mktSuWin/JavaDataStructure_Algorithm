package slidingWindow;

public class lc_largestSum {
    public static void main(String[] args) {
        int[] nums = {-2, 1,-3, 4,-1, 2, 1,-5,4};
/*
        -2, 1,-3, 4,-1, 2, 1,-5,4
         - -2
         ---- -1

                  ---------- 6
                  --------------->

         1 <= nums.length <= 3 * 104
         -105 <= nums[i] <= 105
 */
        System.out.println(largestSum(nums));
    }

    static int largestSum(int[] nums){
        int start = 0;
        int maxSum = 0;
        for(int end = 0; end < nums.length; end++){
            int currSum = 0;
            currSum += nums[end];
            if (nums[end] > currSum){
                currSum = nums[end];
                start = end;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}

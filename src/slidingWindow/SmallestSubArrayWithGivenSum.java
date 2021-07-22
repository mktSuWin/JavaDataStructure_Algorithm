package slidingWindow;

public class SmallestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 2, 7, 8, 1, 2, 8, 1, 0};
        int targetSum = 8;
        System.out.println(smallestSubarrayWithGivenSum(nums, targetSum));
    }
    /*
    { 4, 2, 2, 7, 8, 1, 2, 8, 1, 0};
    ---------
         ----
         ------ grow right side
         8, subarray is 1. It is the best you can do.
         Window is dynamically resizing
     */
    // find smallest subarray, sum of its value is >= 8
    // far left value is changing
    // far right value is changing
    static int smallestSubarrayWithGivenSum(int[] nums, int targetSum){
        int windowStart = 0;
        int currWindowSum = 0;
        int minWindowSize = Integer.MAX_VALUE;
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){
            currWindowSum += nums[windowEnd];
            // Can I do better
            while (currWindowSum >= targetSum){
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart +1);
                currWindowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return minWindowSize;
    }
}

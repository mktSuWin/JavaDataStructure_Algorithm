package slidingWindow;

public class lc_679_LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {

    }

    // Sliding Window Approach
    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int start = 0;
        for(int end = 0; end < nums.length; end++){
            if (end > 0 && nums[end-1] >= nums[end]){
                start = end;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }

    

    // Array Approach
    static int findLengthOfLCIS1(int[] nums) {
        int result = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i-1]){
                count++;
            }else {
                count = 1;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1, curr = 1;
        for(int i = 1; i < nums.length; i++){
            curr = nums[i] > nums[i-1] ? curr+1 : 1;
            max = Math.max(max, curr);
        }
        return max;
    }


}

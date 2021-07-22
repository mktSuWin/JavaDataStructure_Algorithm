package cb_CPMSoc;

public class GFG_Lec2_MaxSubArrayCircular {
    public static void main(String[] args) {

    }

    public static int maxSubArrayCircular(int[] nums){
        int answer = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int sum = nums[i];
            if (sum > answer) answer = sum;
            for(int j = (i + 1) % n; j != i; j = (j+1) % n){
                sum += nums[j];
                answer = Math.max(sum, answer);
            }
        }
        return answer;
    }

    public static int maxSubArrayCircularOptimised(int[] nums){
        int possibleAns1 = maxSubArrayCircularOptimised_HelperKadane(nums);
        int totalSum = 0;
        int curMin = 0, kadaneMin = 0;
        for (int i = 0; i < nums.length;i++){
            int a = nums[i];
            totalSum +=nums[i];
            curMin = Math.min(curMin + a, a);
            kadaneMin = Math.min(curMin, kadaneMin);

        }
        int possibleAns2 = totalSum - kadaneMin;

        return (possibleAns1 > possibleAns2) ? possibleAns1 : possibleAns2;
    }

    public static int maxSubArrayCircularOptimised_HelperKadane(int[] nums){
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int maxSumTillNow = 0;
        for(int i = 0; i < n; i++){
            int a = nums[i];
            maxSumTillNow = Math.max(a, maxSumTillNow+a);
            ans = Math.max(maxSumTillNow, ans);
        }
        return ans;
    }
}


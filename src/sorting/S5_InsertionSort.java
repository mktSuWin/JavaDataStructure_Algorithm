package sorting;

public class S5_InsertionSort {
    public static void main(String[] args) {
        int[] nums = {6, 8, 1, 4, 5, 3, 7, 2};
        int[] answer = insertionSort(nums);
        for(int i: answer){
            System.out.print(i + " ");
        }
    }

    public static int[] insertionSort(int[] nums){
        for(int i = 1; i <= nums.length-1; i++){
            int j = i, temp = nums[i];
            while (j >= 1 && nums[j-1] > temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}

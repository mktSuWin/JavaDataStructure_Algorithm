package bitwise;

public class GFG_FrequenciesOfLimitedRangeArrayElements {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 3, 5};
        int[] result = frequencyCount(nums, 5, 5);
        for(int i:result){
            System.out.print(i + " ");
        }
    }

    public static int[] frequencyCount(int[] nums, int n, int p){
        int[] result = new int[n];
        // Modify current nums array by subtracting 1
        for(int i =0; i < n; i++){
            nums[i] -= 1;
        }
        //
        for(int i =0; i < n; i++){
            int element = nums[i] % p;
            if (element >= n)
                continue;
            nums[element] += p;
        }
        for(int i =0; i < n; i++){
            int frequency = nums[i] / p;
            nums[i] = frequency;
        }
        for(int i =0; i <n; i++){
            result[i] = nums[i];
        }
        return result;
    }
}
/*

int[ ] nums = {2, 3, 2, 3, 5}
int[ ] freq = {0, 0, 0, 0, 0}
If you come across with the number, increase the element in the frequency array.
1. Convert 0th based to 1 based index
   Therefore decrease all the elements by 1 in the given nums array.
   int[ ] nums = {2, 3, 2, 3, 5} => Original nums
   int[ ] nums = {1, 2, 1, 2, 4} => Modified nums

   int[ ] freq = {0, 0, 0, 0, 0} => Initial frequency nums
2. Add n to each element in the Modified nums
   int[ ] freq = {6, 7, 6, 7, 9} => Initial frequency nums
   (frequency * N + element) % p => distributive property
   = (freqency * N) % p + element % p
   = 0                  + element (element is always less than N since we have subtracted by 1)

 */
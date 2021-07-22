package hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc_1748_SumOfUniqueElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
//        System.out.println(sumOfUnique1(nums));
        System.out.println(sumOfUnique(nums));
    }

    public static int sumOfUnique(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if (set.contains(i)){
                continue;
            }
            set.add(i);
        }
        int sum =0;
        for(int i : set){
            sum += i;
        }
        return sum;
    }

    public static int sumOfUnique1(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int element = nums[i];
            if (map.containsKey(element)){
                int newFrequency = map.get(element) +1;
                map.put(element, newFrequency);
            } else {
                map.put(element, 1);
            }
        }

        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int element = entry.getKey(), frequency = entry.getValue();
            if (frequency == 1){
                sum += element;
            }
        }
        return sum;
    }

    public static int sumOfUnique3(int[] nums){
        Set<Integer> set= new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int element = nums[i];
            if (set.contains(element)){
                set.remove(element);
            } else {
                set.add(nums[i]);
            }
        }

        int sum = 0;
        for(int i : set){
            sum += i;
        }
        return sum;
    }

    public static int sumOfUnique2(int[] nums){
        int sum =0;
        int[] frequency = new int[101];
        for(int i =0; i < nums.length;i++){
            frequency[nums[i]]++;
        }

        for(int i = 1; i < 101; i++){
            if (frequency[i] ==1){
                sum += i;
            }
        }
        return sum;
    }


}

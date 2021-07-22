package array;

import java.util.*;

public class lc_349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5};
        int[] nums2 = { 9,4,9,8,4};
        int[] answer = intersection3(nums1, nums2);
        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    public static int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums2){
            if (set1.contains(i)){
                set2.add(i);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for(Integer i : set2){
            result[index++] = i;
        }
        return result;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, 1);
        }

        for(int i : nums2){
            if (map.containsKey(i)){
                int count = map.get(i) + 1;
                map.put(i, count);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i : map.keySet()){
            int value = map.get(i);
            if (value > 1){
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        int index =0;
        for(int i : list){
            result[index++] = i;
        }
        return result;

    }

    public static int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        while ( i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                i++;
            } else if (nums1[i] > nums2[j]){
                j++;
            } else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int index =0;
        for(int s : set){
            result[index++] = s;
        }

        return result;
    }


}

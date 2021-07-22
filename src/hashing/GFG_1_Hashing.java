package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GFG_1_Hashing {
    public static void main(String[] args) {
        // HashSet internally use chaining.
        // It starts to form self-balancing tree.
        Set<String> set = new HashSet<>();
        set.add("GFG");
        set.add("ABC");
        set.add("ABC");
        set.add("Japan");
        System.out.println(set);

        // First hash the key and pass it through the hashfunction.
        // hashfunction will produce key. Pass through map and search for it.
        // Worst case - insertion will take O(n). Check for every elements.
        // If not present, insert it at the end.
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Nagoya");
        map.put(2, "Nagano");
        map.put(3, "Kyoto");
        map.put(4, "Kyoto");

        System.out.println(map);
    }
}

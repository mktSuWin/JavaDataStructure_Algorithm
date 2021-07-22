package graph;

import java.util.Arrays;
import java.util.HashSet;

public class GFG_AdjacencyList {
    static int[][] graph;
    static int n;
    static HashSet<Integer> visited;
    
    public static void main(String[] args) {
        n = 8;
        int[][] matrix = new int[][]{
                {},
                {2, 6},
                {1, 6, 5, 3},
                {2, 5, 4},
                {5, 3},
                {6, 2, 3, 4},
                {1, 2, 5},
                {8},
                {7}
        };

        for(int[] i: matrix){
            System.out.println(Arrays.toString(i));
        }
        visited = new HashSet<>();
        System.out.println( "\n" + isConnected(5,6));

    }



    public static boolean isConnected (int source, int target){
        if (source == target){
            return true;
        } else if (visited.contains(source)){
            return false;
        }
        visited.add(source);
        for(int i : graph[source]){
            if(graph[source][i] == 1){
                boolean check = isConnected(i, target);
                if(check == true) return true;
            }
        }
        return false;
    }
}

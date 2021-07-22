package graph;

import java.util.Arrays;

public class GFG_AdjacencyMatrix {
    public static void main(String[] args) {
        int n = 6;
        int[][] matrix = new int[][]{
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 0, 0},
                {1, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 0}
        };
        for(int[] i : matrix){
            System.out.println(Arrays.toString(i));
        }
        isConnected(5,6);

//        for(int i = 0; i < n; i++){
//            for(matrix[5][i] ==1){
//                // node 5 and node i are connected
//            }
//        }

        // If you place a diagonal line, you can see the mirror images if there is a connection
    }
    static int[][] graph;
    static int n;
    public static boolean isConnected (int source, int target){
        if (source == target){
            return true;
        }

        for(int i = 0; i < n; i++){
            if(graph[source][i] == 1){
                boolean check = isConnected(i, target);
                if(check == true) return true;
            }
        }
        return false;
    }
}

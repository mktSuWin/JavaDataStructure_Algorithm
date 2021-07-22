package graph;

import java.util.ArrayList;

public class G1_AdjacencyMatrix_Creation {
    public static void main(String[] args) {

        // Adjacency Matrix
        int n = 3, m = 3;
        int adjMatrix[][] = new int[n+1][n+1];
        // edge 1 --2
        adjMatrix[1][2] = 1;
        adjMatrix[2][1] =1;

        // edge 2 ---3
        adjMatrix[2][3] = 1;
        adjMatrix[3][2] = 1;

        // edge 1 ---3
        adjMatrix[1][3] = 1;
        adjMatrix[3][1] =1;

        // Adjacency List
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i =0; i <=n; i++){
            adjList.add(new ArrayList<>());
        }

        // edge 1---2
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        // edge 2 ---3
        adjList.get(2).add(3);
        adjList.get(3).add(2);

        // edge 1 ---3
        adjList.get(1).add(3);
        adjList.get(3).add(1);

        for(int i = 1; i < n; i++){
            for(int j = 0; j < adjList.get(i).size();j++){
                System.out.println(adjList.get(i).get(j)+ " ");
            }
            System.out.println();
        }


    }
}

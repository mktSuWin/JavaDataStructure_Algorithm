package codeForces;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
https://codeforces.com/problemset/problem/893/C

n characters in Overcity 1
m number of pairs of friends

            0----0
            \
             \
             0
            /  \
           0    0


           0--0----0---0


           Bunch of graphs
           DFS on

5 2
2 5 3 4 8
1 4
4 5
        1   2   3   4   5
     ----------------------
     1  0   0   0   1   0
     2  0   0   0   0   0
     3  0   0   0   0   0
     4  1   0   0   0   1
     5  0   0   0   1   0


5 2         num of characters in Overcity n = 5, num of pairs of friends m = 2
0   1   2   3   4
2   5   3   4   8
1   4
4   5

10  0
1   2   3   4   5   6   7   8   9   10


 */
// Find all the connected components of the graph

public class CF_C_Rumour {
    // In the first example, there are three components.
    // To keep track of current min gold cost for each component,
    // use currentMin.

    static int N, M, currentMin;
    static long  answer = 0;
    static boolean[] visited; // global visited to make sure they will not be visited again in next iteration
    static int[] goldCost;
    static int[][] friendsConnections;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        goldCost = new int[N];
        // This is to get goldCost array asked by each ith character
        for(int i = 0; i < N; i++){
            goldCost[i] = sc.nextInt();
        }
        visited = new boolean[N];
        friendsConnections = new int[N][N];

        // Create adjaceny matrix and fill it up with M friends pairs
        // Substract 1 so that we can get 1th based indexing
        for(int i = 0; i < M; i++){
            int friend1 = sc.nextInt()-1;
            int friend2 = sc.nextInt()-1;
            // connected 1 - 4, and 4 - 1
            // Edges are bidirectional
            friendsConnections[friend1][friend2] = 1;
            friendsConnections[friend2][friend1] = 1;
        }

        // Look through all the nodes
        for(int i = 0; i <N; i++){
            // first check whether the node has been visited/ 0 -> 3 -> 4,
            // therefore, 3 and 4 will not be visited again.
            if (!visited[i]){
                // Create a new component with that node i
                // And currentMin to that node goldCost
                currentMin = goldCost[i];
                // DFS to go to all the nodes in this component
                dfsStack(i);
                System.out.println("******************************");
                // After finishing this DFS, currentMin : is the goldCost for this component
                answer += currentMin;
            }
        }
        // Have visited all the components
        System.out.println(answer);

    }

    // Stack
    public static void dfs(int node){
        if (!visited[node]){
            System.out.println(node + " ");
            visited[node] = true;
            currentMin = Math.min(currentMin, goldCost[node]);
            for(int i = 0; i < friendsConnections.length; i++){
                if (friendsConnections[node][i] == 1){
                    dfs(i);
                }
            }
        }
    }


    public static void dfsStack(int node){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(node);
        while(!stack.isEmpty()){
            node = stack.pop();
            if (!visited[node]){
                System.out.println(node + " ");
                visited[node] = true;
                currentMin = Math.min(currentMin, goldCost[node]);
                for(int i = 0; i < friendsConnections.length; i++){
                    if (friendsConnections[node][i] == 1){
                        stack.push(i);
                    }
                }
            }
        }
    }
}














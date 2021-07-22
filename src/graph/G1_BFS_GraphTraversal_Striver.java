package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G1_BFS_GraphTraversal_Striver {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> bfsGraphTraversal(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean visited[] = new boolean[V+1];
        for(int i = 1; i <= V; i++){
            if (visited[i] == false){
                // Create queue and add vertex to queue
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()){
                    Integer node = q.poll();
                    bfs.add(node);
                    // For the node you have taken out
                    // from queue, you visit all its adjacent nodes
                    for(Integer it : adj.get(node)){
                        if (visited[i] == false){
                            visited[i] = true;
                            q.add(it);
                        }
                    }
                }
            }
        }
        return bfs;
    }
}






































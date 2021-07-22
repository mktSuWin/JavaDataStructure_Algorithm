package graph;


// BFS is similar to Level order traversal
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Graph {
    public final int MAX_INT = 20;
    public Vertex vertexArray [];
    public int[][] adjMatrix;
    public Stack stack;
    public Queue queue;
    int nVertex;
    // Adjacency List
    public LinkedList<Integer>  adj[];
    //
    public Graph(){
        vertexArray = new Vertex[MAX_INT];
        adjMatrix = new int[MAX_INT][MAX_INT];
        nVertex = 0;
        for(int i = 0; i < MAX_INT; i++){
            for(int j = 0; j < MAX_INT; j++){
                adjMatrix[i][j] = 0;
            }
        }
        stack = new Stack<>();
        queue = new java.util.LinkedList<Integer>();
    }

    Graph(int number){
        vertexArray = new Vertex[number];
        adj = new LinkedList[number];
        for(int i =0; i < number; i++){
            adj[i] = new LinkedList<>();
        }
    }
    // Add vertex
    public void addVertex(char data){
        Vertex vertex = new Vertex(data);
        vertexArray[nVertex++] = vertex;
    }

    // Add edge
    public void addEdge(int row, int col){
        adjMatrix[row][col] = 1;
    }

    // Add edge list to Adjacency List
    public void addEdgeLIst(int i, int j){
        adj[i].add(j);
    }

    // Don't fully understand this part
    public int getAdjacentVertex(int v){
        for(int j = 0; j < nVertex; j++){
            if (adjMatrix[v][j] == 1 && vertexArray[j].wasVisited == false){
                return j;
            }
        }
        return -1;
    }

    public void displayVertex(int v){
        System.out.println(vertexArray[v].label);
    }

    public void DFS(){
        // Source vertex - mark as visited
        vertexArray[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while(!stack.isEmpty()){
            int v = getAdjacentVertex((int) stack.peek());
            if (v == -1){
                stack.pop();
            }else {
                vertexArray[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for(int j = 0; j < nVertex; j++){
            vertexArray[j].wasVisited = false;
        }
    }


    public void BFS(){
        vertexArray[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        while (!queue.isEmpty()){
            int v1 = (int) queue.remove();
            int v2 = getAdjacentVertex(v1);
            while ((v2 = getAdjacentVertex(v1)) != -1){
                vertexArray[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for(int j = 0; j < nVertex; j++){
            vertexArray[j].wasVisited = false;
        }
    }

    public boolean findPathExist(char data){
        vertexArray[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        while (!queue.isEmpty()){
            int v1 = (int) queue.remove();
            int v2 = 0;
            while ((v2 = getAdjacentVertex(v1)) != -1){
                if (data == vertexArray[v2].label){
                    return true;
                }
                vertexArray[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        return false;
    }
}
















package graph;
/*       0   1   2   3   4
         A   B   C   D   E
0     A  0   1   1   0   0
1     B  0   0   1   0   0
2     C  1   0   0   1   0
3     D
4     E
 */
public class Graph_Driver {
    public static void main(String[] args) {
        Graph gp = new Graph();
        gp.addVertex('A');
        gp.addVertex('B');
        gp.addVertex('C');
        gp.addVertex('D');
        gp.addVertex('E');

        gp.addEdge(0,1); // AB
        gp.addEdge(0, 2); // AC
        gp.addEdge(1, 2); // BC
        gp.addEdge(2, 0); // CA
        gp.addEdge(2, 3); //
        gp.addEdge(3, 3); //

        gp.BFS();
        System.out.println(gp.findPathExist('D'));
    }
}

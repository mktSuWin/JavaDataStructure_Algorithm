package binary_tree;
 /*
    Given a binary tree, and a node x in the tree is named good,
    if its path from root to x, there is no nodes with a value greater than x
    return the number of good nodes in the binary tree

                3
              /   \
             1      4
           /       /  \
          3       1    5
     output = 4
     root(3)
     root(1) 1 < 3 , no
     root(3) 3 > 1 , yes
     root(4) 4 > 3, yes
     root(5), 5 > 4, yes

     static int goodNodesInTree(Node x){
        return 0;
    }
    1. Check if the tree node is null or edge case
    2. Traverse - Depth First Search traversal
        initialise int n = 0 for counting
        If root value is greater than the next visited node, increment it.
        Recursion or iterative approach?? I have forgotten about it
        Recursive base case is when node becomes null, come back up
    3. Once finish left subtree, go to right subtree and compare the node value
     */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GFG__binaryTree {
    public static void main(String[] args) {
        NodeGFG root = new NodeGFG(1);
        root.left = new NodeGFG(2);
        root.right = new NodeGFG(3);
        root.left.left = new NodeGFG(4);
        root.left.right = new NodeGFG(5);
        root.right.left = new NodeGFG(60);
        root.right.right = new NodeGFG(7);
        ArrayList<Integer> inorderTraversal = new ArrayList<>();
        inorder(root, inorderTraversal);
        // System.out.println(inorderTraversal);
        //========================
        ArrayList<Integer> bfsOrder = new ArrayList<>();
        bfs(root, bfsOrder);
        // System.out.println(bfsOrder);
        // System.out.println(bfsOrder.size());
//        ByReference ob = countBinaryTreeNodes(root, new ByReference());
//        System.out.println(ob.count);
//
//        int count = countBinaryTreeNodes1(root, 0);
//        System.out.println(count);

//        System.out.println(countBinaryTreeNodes2(root));
//        System.out.println(findMax(root));

        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        printNodesAtDistanceKFromGivenNode(root, adj);
        for(int key : adj.keySet()){
            System.out.println(key + " : " + adj);
        }


    }
    // https://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
    public static ByReference countBinaryTreeNodes(NodeGFG root, ByReference ob){
        // int count is a primitive data type. Not passed by reference type ,
        if (root == null) return ob;
       ob.count++;
        countBinaryTreeNodes(root.left, ob);
        countBinaryTreeNodes(root.right, ob);
        return ob;
    }

    // https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
    public static int findMax(NodeGFG root){
        if (root == null) return Integer.MIN_VALUE;
        int max = root.val;
//        max  = Math.max( findMax(root.left), max);
//        max = Math.max(findMax(root.right), max);
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        if (leftMax > max)
            max = leftMax;
        if (rightMax > max)
            max = rightMax;
        // return leftMax > rightMax ? Math.max(max, leftMax) : Math.max(max, rightMax);
        return max;
    }

    // https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
    // reroot - change the tree
    // binary tree converting it into adjacency list
    // visit neighours of 14
    // Study this problem , Don't understand
    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
    public static void printNodesAtDistanceKFromGivenNode(NodeGFG root, HashMap<Integer, ArrayList<Integer>> adj){
        int currNodeLevel = root.val;
        adj.putIfAbsent(currNodeLevel, new ArrayList<>());
        if (root.left != null) {
            int leftLevel = root.left.val;
            adj.get(currNodeLevel).add(leftLevel);
            adj.put(leftLevel, new ArrayList<>());
            printNodesAtDistanceKFromGivenNode(root.left, adj);
        }

        if (root.right != null){
            int rightLevel = root.right.val;
            adj.get(currNodeLevel).add(rightLevel);
            adj.put(rightLevel, new ArrayList<>());
            printNodesAtDistanceKFromGivenNode(root.right, adj);
        }
    }
    // Home work
    // https://leetcode.com/problems/binary-tree-right-side-view/solution/



    // https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
    // Divide and conquer
    public static boolean checkChildrenSumProperty(NodeGFG root){
        // corner case - leaf node
        if (root.left == null && root.right == null) return true;

        int leftVal = 0, rightVal = 0;
        if (root.left != null) leftVal = root.left.val;
        if (root.right !=null) rightVal = root.right.val;
        if(leftVal + rightVal != root.val) return false;

        if (root.left != null && checkChildrenSumProperty(root.left) == false) return false;
        if (root.right !=null && checkChildrenSumProperty(root.right) == false) return false;
        return true;
    }

    // Homework
    // https://leetcode.com/problems/balanced-binary-tree/

    //Homework
    // https://leetcode.com/problems/maximum-width-of-binary-tree/

    // Home work
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    // preoder  3   9   20  15  7   root    left    right
    // inorder  9   3   15  20  7   left    root    right
    // 3    9   20


    // Home work
    //https://leetcode.com/problems/diameter-of-binary-tree/
    public static int countBinaryTreeNodes1(NodeGFG root, int count){
        // int count is a primitive data type. Not passed by reference type ,
        if (root == null) return count;
        count++;
        count = countBinaryTreeNodes1(root.left, count); // manually override the count
        count = countBinaryTreeNodes1(root.right, count); // manually override the count
        return count;
    }

    // Homework
    // https://leetcode.com/problems/diameter-of-binary-tree/submissions/


    // Divide and Conquer Strategy - count each
    //========================================
    /*
            1
          /   \
         2     3
       /  \
      4    5
      Count the current node
      Divide the tree into two : left subtree and right subtree
      Then count each tree individually
     */
    public static int countBinaryTreeNodes2(NodeGFG root){
        int count = 1; // current Root
        if (root == null) return 0;
        // break the problem into two
//        count += countBinaryTreeNodes2(root.left);
//        count += countBinaryTreeNodes2(root.right);
//        return count;
        return 1 + countBinaryTreeNodes2(root.left) + countBinaryTreeNodes2(root.right);
    }

    // left root null
    public static void inorder(NodeGFG root, List<Integer> order){
        if (root == null) return;
        inorder(root.left, order);
        order.add(root.val);
        inorder(root.right, order);
    }

    public static void preorder(NodeGFG root, List<Integer> order){
        if(root == null) return;
        order.add(root.val);
        preorder(root.left, order);
        preorder(root.right, order);
    }

    public static void bfs(NodeGFG root, List<Integer> order){
        ArrayDeque<NodeGFG> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            NodeGFG popped = queue.pollFirst();
            order.add(popped.val);
            // System.out.print(popped.val + " ,");
            if (popped.left != null) queue.addLast(popped.left);
            if (popped.right !=null) queue.addLast(popped.right);
        }
    }

    // Calculate size of a tree | recursion
    public static void sizeOfBinaryTree(NodeGFG root){

    }

}

class NodeGFG {
    NodeGFG[] children;
    NodeGFG left = null;
    NodeGFG right = null;
    int val;
    public NodeGFG(int val){
        this.val = val;
    }
}


class ByReference{
    int count;

//    public ByReference(int count){
//        this.count = count;
//    }
    // primitive data type -> pass by value
    // Byrefernece -> user defined data type -> pass by reference
}
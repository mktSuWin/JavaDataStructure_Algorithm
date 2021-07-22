package binarySearchTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class bst_implementation {
    public static void main(String[] args) {
        int[] A = new int[] {5, 10, 7, 13, 8, 2};
        for(int i : A)
            insert(i);
        inorder(root);

        NodeGFG1 root1= new NodeGFG1(3);
        root1.left = new NodeGFG1(2);
        root1.right = new NodeGFG1(5);
        root1.left.left = new NodeGFG1(1);
        root1.left.right = new NodeGFG1(3);
        System.out.println(checkBST(root1));
    }


    static NodeGFG1 root;
    static void insert(int val){
        if (root == null){
            root = new NodeGFG1(val);
        } else{
            NodeGFG1 curr = root;
            // check where to put the value
            while(true){
                NodeGFG1 next;
                if (curr.val > val){ // go to left subtree
                    next = curr.left;
                    if (next == null){
                        curr.left = new NodeGFG1(val);
                        break;
                    }
                }else { // go to right subtree
                    next = curr.right;
                    if (next == null){
                        curr.right = new NodeGFG1(val);
                        break;
                    }
                }
                curr = next;
            }
        }
    }

    // delete node from BST
    /*
    case 1 : leaf node - delete
    case 2 : contains 1 child
    case 3 : contains 2 children
        Replace the node with inorder successor
            10

       5             11

             10.5       11.5

                    14

                 13

   ====================================================================
   inorder - left, root, right
   10, 11, 13, 13.1, 13.2, 13.3, 14, 15
                10
                 \
                 13
               /    \
              11     15
                     /
                    14
                  /
                 13.1
                   \
                   13.2
                     \
                      13.3
     */
    // Home work
    static void delete(int val){

    }


    /*
        // floor = greatest value <= acutal value
                10

                    15

                 13        16

                              20
     */

    public static void inorder(NodeGFG1 root){
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void preorder(NodeGFG1 root){
        if (root == null) return;
        System.out.println(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /*
    https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
     */
    // Not optimised approach O(n^2)
    //=================================
    public static boolean checkBST(NodeGFG1 root){
        if (root.left != null && !checkAllNodesLess( root.left, root.val)){
            return false;
        } else if (root.left != null && !checkBST(root.left)){
            return false;
        } else if (root.right != null && checkAllNodesMore(root.right, root.val)){
            return false;
        } else if (root.right != null && !checkBST(root.right)){
            return false;
        }
        return true;
    }
    // all the nodes in left subtree less than root value
    static boolean checkAllNodesLess(NodeGFG1 curr, int val){
        if (curr == null) return true;
        else if (curr.val > val) return false;
        else if(!checkAllNodesLess(curr.left, val) || !checkAllNodesLess(curr.right,val)){
            return false;
        }
        return true;
    }

    static boolean checkAllNodesMore(NodeGFG1 curr, int val){
        if (curr == null) return true;
        else if (curr.val < val) return false;
        else if(! checkAllNodesMore(curr.left, val) || !checkAllNodesMore(curr.right,val)){
            return false;
        }
        return true;
    }

    /*
    Top view of Binary tree
    - Assign x coordinate to every node starting from root.
    - at root, x = 0
    - every time goes left, subtract -1
    -


    Maintain HashMap
    use putIfAbsent
    x-coordinate        List
    0                   1
    -1                  2
    -2                  4

     */
    static void topViewOfBinaryTree(NodeGFG1 root, int x, HashMap<Integer, Integer> map){
        if (root == null) return;
        map.putIfAbsent(x, root.val);
        topViewOfBinaryTree(root.left, x-1, map);
        topViewOfBinaryTree(root.right, x+1, map);

    }

    static HashMap<Integer, Integer> map = new HashMap<>();
    static void bottomViewOfBinaryTree(NodeGFG1 root, int x, int depth, HashMap<Integer, Integer> map){
        if (root == null) return;
        if (depth > map.getOrDefault(x, 0)){
            map.put(x, root.val);
            map.put(x, depth);
        }
        bottomViewOfBinaryTree(root.left, x-1, depth +1, map);
        bottomViewOfBinaryTree(root.right, x+1, depth+1, map);

    }
}

class NodeGFG1 {

    int val;
    NodeGFG1 left, right;
    public NodeGFG1(int val){
        this.val = val;
    }
}

/*
class GFG {
	public static void main(String[] args) {
		int[] A = new int[] {5, 10, 7, 13, 8, 2};
		for (int ele : A) insert(ele);
		inorder(root);
	}

	static Node root;

	static void insert(int val) {
		if (root == null) {
			root = new Node(val);
		} else {
			Node curr = root;
			while (true) {
				Node next;
				if (curr.val > val) {
					next = curr.left;
					if (next == null) {
						curr.left = new Node(val);
						break;
					}
				} else {
					next = curr.right;
					if (next == null) {
						curr.right = new Node(val);
						break;
					}
				}
				curr = next;
			}
		}
	}

	static void inorder(Node root) {
		if (root == null) return;
		System.out.print(root.val + " ");
		inorder(root.left);
		inorder(root.right);
	}
}

class Node {
	int val;
	Node left, right;

	Node(int v) {
		val = v;
	}
}
 */

package tree;

import java.util.LinkedList;
import java.util.Queue;

public class lc_993_Cousins_Of_Tree {
    public static void main(String[] args) {

    }
/*
// Java Solution
//======================
    public boolean isCousins(TreeNode root, int x, int y){
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int nodeNumAtThisLevel = queue.size();

            boolean foundx = false;
            boolean foundY = false;

            for(int i =0; i < nodeNumAtThisLevel; i++){
                TreeNode node = queue.remove(); // queue.poll()
                if (node.val == x) foundx = true;
                if (node.val == y) foundY = true;

                // Check for siblings since they have the same parent
                if (node.left !=null && node.right !=null){
                    if (node.left.val == x && node.right.val == y) return false;
                    if (node.left.val == y && node.right.val == x) return false;
                }

                if (node.left !=null){
                    queue.add(node.left); // queue.offer()
                }

                if (node.right !=null){
                    queue.add(node.right);
                }
            }
            if (foundx && foundx) return true;
        }
        return false;

    }

    */

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        // 이진트리는 left < right 이다. 

        TreeNode node =root;
        while(true){
            
            if(node==null || node.val==val) break;

            if(node.val > val) node =node.left;
            else if (node.val <val) node = node.right; 

        }

        return node;
    }
}
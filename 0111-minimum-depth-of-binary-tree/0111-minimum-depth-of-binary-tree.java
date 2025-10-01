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

import java.util.*;

class Solution {
    public int minDepth(TreeNode root) {

        if(root==null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth=1;
        while(!q.isEmpty()){
            int size=q.size();                
            for(int i=0;i<size;i++){
                TreeNode now = q.poll();
                if(now.left==null&& now.right==null){
                    return depth;
                }

                if(now.left!=null) q.offer(now.left);
                if(now.right!=null) q.offer(now.right);
            }
            depth++;
        }
        return depth;
        
    }
}
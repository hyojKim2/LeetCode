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
    
    static int answer=0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        answer=0;
        dfs( root, low, high);
        return answer;
    }
    static public void dfs(TreeNode now,  int low, int high){


        if(now.val>=low && now.val<=high ){ //조건만족시
            answer+=now.val; 
        }
        if(now.left!=null ) //왼쪽자식이 있다면
            dfs( now.left, low, high);
        if(now.right!=null) //오른쪽 자식이 잇다면
            dfs( now.right, low, high);


    }
}
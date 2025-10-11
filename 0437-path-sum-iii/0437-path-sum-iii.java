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
    int target;
    int answer=0;
    public int pathSum(TreeNode root, int targetSum) {
        target=targetSum;

        traverse(root);
        return answer;
    }

    //현재 노드를 시작점으로 
    public void traverse(TreeNode root){
        if(root==null) return;
        DFS(root, 0);
        traverse(root.left);
        traverse(root.right);
    }

    public void DFS(TreeNode root, long sum){

        if(root==null) return ;

        sum+=root.val;
        if(sum==target){
            answer++;
        }
        DFS(root.left, sum);
        DFS(root.right, sum);

    }
}
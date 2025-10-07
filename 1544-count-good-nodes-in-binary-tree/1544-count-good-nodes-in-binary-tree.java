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
    int answer;
    public int goodNodes(TreeNode root) {
        //시
        answer=0;
        DFS(root, root.val);

        return answer;
        
    }

    public void DFS(TreeNode root, int max){
        if(root==null){
            return ;
        }
        if(root.val >=max){
            max=root.val;
            answer++;
        }
        DFS(root.left, max);
        DFS(root.right, max);

    }
}
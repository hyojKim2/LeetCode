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
    static int good=0;
    public int goodNodes(TreeNode root) {
        // 본인 노드까지 검사
        good=0;
        DFS(root, root.val);

        return good;
    }

    public void DFS(TreeNode root, int max){
        if(root==null) return;
        if(max <=root.val){
            good++;
            max=root.val;
        }
        DFS(root.left, max);
        DFS(root.right, max);

    }

}
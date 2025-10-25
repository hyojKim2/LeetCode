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
    public TreeNode deleteNode(TreeNode root, int key) {
    
        if(root==null) return null;
        if(root.val>key) root.left= deleteNode(root.left, key);
        else if(root.val <key) root.right= deleteNode(root.right, key);
        else{
            //왼쪽 자식만 존재
            if(root.right==null){
                root=root.left;
                return root;
            }
            else if(root.left==null){
                root=root.right;
                return root;
            }
            else{ //자식이 둘 다 존재 
                TreeNode min=rightMin(root.right);
                root.val=min.val; //교체
                //min 노드 삭제
                root.right = deleteNode(root.right, min.val);
            }

        }
        return root;

    
    }

    public TreeNode rightMin(TreeNode root){
        while(root.left !=null ){
            root=root.left;
        }
        return root;
        
    }

}
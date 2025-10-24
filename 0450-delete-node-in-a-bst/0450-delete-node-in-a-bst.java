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
public class Solution {
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (key < root.val) {
            // key가 작으면 왼쪽 서브트리로 이동
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // key가 크면 오른쪽 서브트리로 이동
            root.right = deleteNode(root.right, key);
        } else {
            // key == root.val -> 삭제할 노드 찾음
            if (root.left == null) {
                // 왼쪽 자식 없음 → 오른쪽 자식으로 대체
                return root.right;
            } else if (root.right == null) {
                // 오른쪽 자식 없음 → 왼쪽 자식으로 대체
                return root.left;
            } else {
                // 두 자식 모두 존재 → 오른쪽 서브트리 최소값으로 교체
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val; // 값 교체
                root.right = deleteNode(root.right, minNode.val); // 최소값 삭제
            }
        }
        return root;
    }
    
    // 오른쪽 서브트리의 최소값 찾기
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
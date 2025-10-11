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

import java.util.HashMap;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1); // 누적합이 targetSum과 같을 때를 위해 초기값
        return dfs(root, 0L, targetSum, prefixSum);
    }
    
    private int dfs(TreeNode node, long currSum, int target, HashMap<Long, Integer> prefixSum) {
        if (node == null) return 0;
        
        currSum += node.val;
        int count = prefixSum.getOrDefault(currSum - target, 0); // 이전 누적합과 비교
        
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        
        count += dfs(node.left, currSum, target, prefixSum);
        count += dfs(node.right, currSum, target, prefixSum);
        
        prefixSum.put(currSum, prefixSum.get(currSum) - 1); // 백트래킹
        
        return count;
    }
}
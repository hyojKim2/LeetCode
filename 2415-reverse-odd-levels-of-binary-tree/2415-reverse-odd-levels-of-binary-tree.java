class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }

    void dfs(TreeNode L, TreeNode R, int level) {
        if (L == null || R == null) return;

        if (level % 2 == 1) {
            int temp = L.val;
            L.val = R.val;
            R.val = temp;
        }

        dfs(L.left, R.right, level + 1);
        dfs(L.right, R.left, level + 1);
    }
}
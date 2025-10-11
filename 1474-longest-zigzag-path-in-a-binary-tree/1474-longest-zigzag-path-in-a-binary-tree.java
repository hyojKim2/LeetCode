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
    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return max-1;
    }

    // return int[]{leftZigZag, rightZigZag}
    private int[] dfs(TreeNode node) {
        if(node == null) return new int[]{0, 0};

        int[] left = dfs(node.left);   // 왼쪽 자식 탐색
        int[] right = dfs(node.right); // 오른쪽 자식 탐색

        // 부모에서 계산
        int leftZig = left[1] + 1;   // 왼쪽 시작 → 다음은 오른쪽
        int rightZig = right[0] + 1; // 오른쪽 시작 → 다음은 왼쪽

        max = Math.max(max, Math.max(leftZig, rightZig));

        return new int[]{leftZig, rightZig};
    }
}


    // int max;
    // public int longestZigZag(TreeNode root) {
    //     //복잡도 log(n log N) 으로 끝내야함. 
    //     //left: 0, right: 1
    //     max=0;
    //     traverse(root);
    //     return max -1;
    // }

    // //모든 노드에 대하여 찾기. 
    // public void traverse(TreeNode root){
    //     if(root==null) return;
    //     //현재 노드 
    //     dfs(root, 0, 0);
    //     dfs(root, 1, 0);

    //     //자식을 기준으로 
    //     traverse(root.left);
    //     traverse(root.right);
    // }

    // public void dfs (TreeNode root, int dir, int cnt){

    //     if(root==null){
    //         if(cnt>=max) max=cnt;
    //         return;
    //     }

    //     //다음 노드, 방향 찾기 
    //     TreeNode next = dir == 0 ? root.left : root.right;
    //     int nextdir = dir==0 ? 1: 0;

    //     dfs(next, nextdir, cnt+1); 
    // }
// }
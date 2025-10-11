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
    public int res = 0; //최대 지그재그 길이 

    public int longestZigZag(TreeNode root) {
        dfs(root, 1); //시작 방향은 상관없음. 
        return res;
    }

    public int dfs(TreeNode n, int leg){
        if(n == null) return 0;

        //노드의 지그재그 왼/오 최대 길이 
        int left = dfs(n.left, 1);
        int right = dfs(n.right, 2);
        res = Math.max(res, Math.max(left, right));

        //방향에 따른 길이 계산. 
        if(leg == 1){ //현재 방향(내가 타고온 방향)이 left면, 오른쪽으로 가야함. 
            res = Math.max(res, left);
            return right+1;
        }
        else{
            res = Math.max(res, right);
            return left+1;
        }
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
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
    public int max = 0; //최대 지그재그 길이 

    public int longestZigZag(TreeNode root) {
        //0:left, 1: right;
        dfs(root, 0); //시작 방향은 상관없음. 
        return max;
    }

    //노드가 가진 방향 기반, 최대 지그재그 길이를 구한다. 
    public int dfs(TreeNode n, int leg){ 
        if(n==null)return 0;
        
        int left=dfs(n.left, 0);
        int right=dfs(n.right, 1);

        //최대 값을 갱신한다. 
        max=Math.max(max, Math.max(left, right));

        if(leg==0){ //left로 왔으니 right방향
            return right+1;
        } 
        else{
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
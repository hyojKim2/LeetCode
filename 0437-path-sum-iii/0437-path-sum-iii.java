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
 import java.util.*;

class Solution {

    //HashMap으로 풀기
    public int pathSum(TreeNode root, int targetSum){

        //누적합을 담음 
        HashMap<Long, Integer>  map = new HashMap<>();
        map.put(0L, 1); // 루트부터 시작하는 경로 존재시 처리. 
        return dfs(root, 0, targetSum, map);

    }

    public int dfs(TreeNode root, long curr, int target, HashMap<Long, Integer> map ){

        //핵심 개념: 현재누적합 - 이전 누적합 = target => 현재누적합 -target =이전 누적합
        // => (1)현재누적합 -target에 일치하는 이전 누적합의 개수를 구한다. 

        if(root==null) return 0;
        
        curr+= root.val;
        int count = map.getOrDefault(curr-target, 0); // (1) 이전 누적합에 존재시 찾고, 없으면 0

        //(2) curr을 map누적합에 넣어준다. 
        map.put( curr, map.getOrDefault(curr, 0)+1);

        count+=dfs(root.left, curr, target, map);
        count+=dfs(root.right, curr, target, map);

        //백트래킹:현재 누적합 빼준다
        map.put(curr, map.get(curr)-1);
        return count;
    }

    // int target;
    // int answer=0;
    // public int pathSum(TreeNode root, int targetSum) {
    //     target=targetSum;

    //     traverse(root);
    //     return answer;
    // }

    // //현재 노드를 시작점으로 
    // public void traverse(TreeNode root){
    //     if(root==null) return;
    //     DFS(root, 0);
    //     traverse(root.left);
    //     traverse(root.right);
    // }

    // public void DFS(TreeNode root, long sum){

    //     if(root==null) return ;

    //     sum+=root.val;
    //     if(sum==target){
    //         answer++;
    //     }
    //     DFS(root.left, sum);
    //     DFS(root.right, sum);

    // }
}
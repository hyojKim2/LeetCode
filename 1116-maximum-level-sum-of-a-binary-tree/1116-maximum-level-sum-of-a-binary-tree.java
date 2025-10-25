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
    public int maxLevelSum(TreeNode root) {
        //복잡도는 nLog(n)이하
        int sum=Integer.MIN_VALUE;
        int maxSum=Integer.MIN_VALUE;
        int answer=999999;
        int nowLevel=0;

        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        while(true){
            if(sum > maxSum){ 
                maxSum=sum;
                answer=nowLevel;
                //System.out.println(sum + " maxSum: " + maxSum + " answer "+ answer);
            }

            if(q.size()==0) break;
            sum=0;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                sum+=node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            nowLevel++;

        }

        return answer;


        
    }
}
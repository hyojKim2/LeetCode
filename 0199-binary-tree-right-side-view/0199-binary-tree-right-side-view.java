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
    public List<Integer> rightSideView(TreeNode root) {

        /** BFS로 한 깊이마다 가장 우측 노드를 반환한다. 
         */

        if (root==null) return new ArrayList<>();
        
    
        List<Integer> answer = new ArrayList<>();
        List<TreeNode> visited = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        int currDepth=0;
        List<Integer> depth = new ArrayList<>(); 
        depth.add(0);

        while(!q.isEmpty()){

            
            TreeNode node= q.poll();
            visited.add(node); depth.remove(0); //방문 처리 

            //널
            if(node.left!=null) {
                q.offer(node.left); depth.add(currDepth+1); 
            }
            
            if(node.right!=null) {
                q.offer(node.right);depth.add(currDepth+1); 
            
            } 

            if(depth.size() > 0 && depth.get(0)!=currDepth ) { 
                // 현재깊이와 리스트의 깊이가 다르다면 node가 현 깊이에서 최우측. 
                answer.add(node.val);
                currDepth++;
                System.out.println(q.size());
            }

            if(q.size()==0){ // 큐가 비어있는 경우 처리  
                answer.add(node.val);
                
            }
            

        }

        
        return answer; 
        
    }
}
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

/*
1. 최대깊이 maxDepth와 합계 sum을 전역변수 설정한다.
2. 노드를 DFS순회하여 최하단 노드일시 masDepth와 비교하여 sum을 갱신한다.
3. DFS순회가 완료되면 sum을 반환한다. 

*/
import java.util.*;

class Solution {

    static int maxDepth;
    static int sum;
    public int deepestLeavesSum(TreeNode root) {
        maxDepth=0;
        sum=0;
        DFS(root, 0); 
        
        return sum; //가장 큰 키에 대한 밸류값합 반환
    }

    public void DFS(TreeNode node, int depth){

        if(node.left!=null){ //왼쪽 자식 있을 때
            DFS(node.left, depth+1);
        }
        if(node.right!=null){ //오른쪽 자식 있을 때
            DFS(node.right, depth+1);
        }
        if(node.left== null && node.right==null){ //최하단 노드면
            if(depth==maxDepth){ //maxDepth와 같다면 sum에 합산
                sum+=node.val;
            }
            else if( depth>maxDepth){ //maxDepth를 갱신하고 sum초기화
                maxDepth=depth;
                sum=node.val;
            }
        }
            
    }


}
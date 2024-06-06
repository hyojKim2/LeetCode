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
    static List<TreeNode> AnswerTree;  

    static Map<Integer, List<TreeNode>> memo;  // 메모이제이션을 위한 맵


    public List<TreeNode> allPossibleFBT(int n) {

        memo= new HashMap<>(); //해시맵 선언
        return generateFBT(n);
    }

    public List<TreeNode> generateFBT(int n){ //재귀적으로
        if (memo.containsKey(n)) { //저장되어있는 값을 리턴.
            return memo.get(n);
        }
        List<TreeNode> result = new ArrayList<>(); 

        if (n == 1) { //1인 경우
            result.add(new TreeNode(0));
        } 
        else {

            //왼쪽 노드의 개수-오른쪽 노드의 개수는 [1,1] [3,1] [1,3]...홀수
            for (int leftNodes = 1; leftNodes < n; leftNodes += 2) {
                int rightNodes = n - 1 - leftNodes;
                List<TreeNode> left_subTrees = generateFBT(leftNodes);
                List<TreeNode> right_subTrees = generateFBT(rightNodes);



                for (TreeNode left : left_subTrees) { 
                    for (TreeNode right : right_subTrees) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }
        memo.put(n, result); //해시맵에 넣기 메모이제이션.
        return result; //result반환
    }




}
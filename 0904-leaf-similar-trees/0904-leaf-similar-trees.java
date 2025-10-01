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
    static ArrayList<Integer> list1  = new ArrayList<>();
    static ArrayList<Integer> list2  = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        list1  = new ArrayList<>();
        list2  = new ArrayList<>();
        if(root1.left==null && root1.right==null && root2.left==null && root2.right==null ){
            if(root1.val==root2.val)
                return true;
            else
                return false;
        }
        //DFS로 리프노드 리스트 만들어서 같은지 비교. 
        DFS(root1, list1);
        DFS(root2, list2);
        
        return list1.equals(list2);
    }

    public void DFS(TreeNode root, ArrayList<Integer> list){
        //리프노드를 list에 담는다. 
        if(root!=null) {
            DFS(root.left, list);
            DFS(root.right, list);
            if(root.left ==null && root.right ==null){
                list.add(root.val);
            }

        }

    }

}
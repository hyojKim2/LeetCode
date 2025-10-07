/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // p와 q의 부모를 저장한다. 
    List<TreeNode> pp;
    List<TreeNode> qq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pp=new ArrayList<>();
        qq=new ArrayList<>();
        
        pp= DFS(root, new ArrayList<>(), p.val);
        qq= DFS(root, new ArrayList<>(), q.val);


        //겹치는 것들 자르고, 맨 끝 원소 반환
        pp.retainAll(qq);

        return pp.get(pp.size()-1);

    }

    public List<TreeNode> DFS(TreeNode root, List<TreeNode> list, int key){
        if(root==null) return null;

        list.add(root);
        if(root.val==key){
            return new ArrayList<>(list); //찾으면 복사본 반환. 
        }
        
        List<TreeNode> left= DFS(root.left, list, key);
        if(left!=null) return left; //찾으면 반환
        List<TreeNode> right= DFS(root.right, list, key);
        if(right!=null) return right;

        list.remove(list.size()-1); //백트래킹. 
        return null;

    }
    
}
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
   
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return solve(1,n);
    }
    public List<TreeNode> solve(int start,int n){
        List<TreeNode> list = new ArrayList<>();
        if(start>n){
            list.add(null);
            return list;
        }
        for(int i =start;i<=n;i++){
        List<TreeNode> lefttree = solve(start,i-1);
        List<TreeNode> righttree = solve(i+1,n);

        for(TreeNode left : lefttree){
            for(TreeNode right : righttree){
                TreeNode root = new TreeNode(i);
                root.left=left;
                root.right=right;
                list.add(root);
            }
        }

        }
        return list;
        

    }
    
}
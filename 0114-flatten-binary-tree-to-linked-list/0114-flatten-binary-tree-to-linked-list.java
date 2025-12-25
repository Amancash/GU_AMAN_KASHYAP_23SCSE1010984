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
    

    public void flatten(TreeNode root) {

        if(root==null){
            return;
        }
        TreeNode current = root;
        while(current != null){
            if(current.left!= null){
                TreeNode temp = current.left;
                while(temp.right!= null){
                    temp=temp.right;
                }
                temp.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }



    //    if(root==null) return;
    //    preorder(root);
    }
    // public void preorder(TreeNode root){
    //     if(root==null) return;
    //     TreeNode temp = root.left;
    //     root.left=null;
    //     root.right=temp;
    //     root.right.right=temp;
    //     preorder(root.left.left);
    //     preorder(root.right.right);
    // }
        
    
}
    

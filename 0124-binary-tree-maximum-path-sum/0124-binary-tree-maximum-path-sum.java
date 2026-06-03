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
    public int maxPathSum(TreeNode root) {
        int[] MaxValue =new int[1];
        MaxValue[0]= Integer.MIN_VALUE;
        maxdepthsum(root,MaxValue);
        return MaxValue[0];
    }
    public int maxdepthsum(TreeNode node , int[] MaxValue){
        if(node==null) return 0;
        int leftsum = Math.max(0,maxdepthsum(node.left,MaxValue));
        int rightsum = Math.max(0,maxdepthsum(node.right,MaxValue));

        MaxValue[0] = Math.max(MaxValue[0] , leftsum + rightsum + node.val);
        return Math.max(leftsum,rightsum)+node.val;
    }
}
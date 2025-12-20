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
    public boolean isCousins(TreeNode root, int x, int y) {
       if(root==null) return false;
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);
       while(!q.isEmpty()){
            int size = q.size();
            Boolean foundx = false;
            Boolean foundy=false;
            for(int i =0 ; i <size ; i++){
                TreeNode temp = q.poll();
                if(temp.val==x) foundx=true;
                if(temp.val==y) foundy = true;

                if(temp.left != null && temp.right != null){
                    if((temp.left.val ==x && temp.right.val==y) ||
                        (temp.left.val==y && temp.right.val==x)){
                            return false;
                        }
                }
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null) q.offer(temp.right);
            }
        if(foundx && foundy) return true;
        if(foundx || foundy) return false;
       }
       return false;
        
    }
}
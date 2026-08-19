
class Solution {
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        if(root == null) return Integer.MAX_VALUE;
        if(root.left != null){
            int left = minDiffInBST(root.left);
            ans = Math.min(ans,left);
        }
        if(prev != null){
            ans  = Math.min(ans,root.val-prev.val);
        }
        prev = root;

        if(root.right != null){
            int right = minDiffInBST(root.right);
            ans = Math.min(ans,right);
        }
        return ans;
    }
}
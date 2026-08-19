
class Solution {
    public TreeNode helper(int[] nums,int st,int end) {
        if(st>end) return null;
        int mid = st+(end-st)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,st,mid-1);
        root.right = helper(nums,mid+1,end);
        return root;
        
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length-1;
        return helper(nums,0,n);
        
    }
}

class Solution {
    public void helper(TreeNode root, List<String> ans, String s) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            ans.add(s + root.val);
            return;
        }

        helper(root.left, ans, s + root.val + "->");
        helper(root.right, ans, s + root.val + "->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root,ans,"");
        return ans;
    }
}
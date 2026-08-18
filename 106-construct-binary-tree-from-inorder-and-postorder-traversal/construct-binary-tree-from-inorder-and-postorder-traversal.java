class Solution {

    int postIdx;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int value = postorder[postIdx--];
        TreeNode node = new TreeNode(value);

        int idx = map.get(value);

        node.right = helper(postorder, idx + 1, right);
        node.left = helper(postorder, left, idx - 1);

        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIdx = postorder.length - 1;

        return helper(postorder, 0, inorder.length - 1);
    }
}
class Solution {
    HashMap<Integer, TreeNode> map = new HashMap<>();
    int merged = 0;

    public TreeNode canMerge(List<TreeNode> trees) {
        for (TreeNode root : trees) {
            map.put(root.val, root);
        }

        HashSet<Integer> childRoots = new HashSet<>();

        for (TreeNode root : trees) {
            if (root.left != null) {
                childRoots.add(root.left.val);
            }
            if (root.right != null) {
                childRoots.add(root.right.val);
            }
        }

        TreeNode root = null;

        for (TreeNode node : trees) {
            if (!childRoots.contains(node.val)) {
                root = node;
                break;
            }
        }

        if (root == null) {
            return null;
        }

        merged = 1;
        map.remove(root.val);

        if (!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return null;
        }

        if (merged != trees.size()) {
            return null;
        }

        return root;
    }

    private boolean dfs(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        if (node.left == null && node.right == null) {
            TreeNode tree = map.get(node.val);

            if (tree != null) {
                node.left = tree.left;
                node.right = tree.right;
                map.remove(node.val);
                merged++;
            }
        }

        return dfs(node.left, min, node.val)
            && dfs(node.right, node.val, max);
    }
}
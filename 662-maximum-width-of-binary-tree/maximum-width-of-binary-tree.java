class Solution {
    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            int start = q.peekFirst().index;
            int end = q.peekLast().index;

            maxWidth = Math.max(maxWidth, end - start + 1);

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();

                if (curr.node.left != null) {
                    q.offer(new Pair(curr.node.left, 2 * curr.index + 1));
                }

                if (curr.node.right != null) {
                    q.offer(new Pair(curr.node.right, 2 * curr.index + 2));
                }
            }
        }

        return maxWidth;
    }
}
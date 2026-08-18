class Solution {

    class Pair {
        int row;
        int dist;
        TreeNode data;

        public Pair(int row, int dist, TreeNode data) {
            this.row = row;
            this.dist = dist;
            this.data = data;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0, root));

        HashMap<Integer, List<int[]>> mp = new HashMap<>();

        while (q.size() > 0) {

            Pair p = q.poll();

            TreeNode r = p.data;

            int row = p.row;
            int dist = p.dist;
            int data = r.val;

            mp.putIfAbsent(dist, new ArrayList<>());

            mp.get(dist).add(new int[]{row, data});

            if (r.left != null) {
                q.add(new Pair(row + 1, dist - 1, r.left));
            }

            if (r.right != null) {
                q.add(new Pair(row + 1, dist + 1, r.right));
            }
        }

        List<Integer> keys = new ArrayList<>(mp.keySet());
        Collections.sort(keys);

        List<List<Integer>> ans = new ArrayList<>();

        for (int key : keys) {

            List<int[]> list = mp.get(key);

            Collections.sort(list, (a, b) -> {

                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }

                return a[1] - b[1];
            });

            List<Integer> temp = new ArrayList<>();

            for (int[] arr : list) {
                temp.add(arr[1]);
            }

            ans.add(temp);
        }

        return ans;
    }
}
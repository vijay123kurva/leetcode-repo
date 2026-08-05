
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        
        int[] unique = new int[n];
        int m = 0;
        for (int x : nums) {
            if (m == 0 || unique[m - 1] != x) {
                unique[m++] = x;
            }
        }

        int ans = n;
        int j = 0;

        for (int i = 0; i < m; i++) {
            while (j < m && unique[j] < unique[i] + n) {
                j++;
            }

            int keep = j - i;
            ans = Math.min(ans, n - keep);
        }

        return ans;
    }
}


class Solution {
    private int[] memo;

    public int climbStairs(int n, int[] costs) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(n, costs);
    }

    private int solve(int i, int[] costs) {
    
        if (i == 0) {
            return 0;
        }

        
        if (memo[i] != -1) {
            return memo[i];
        }

        int currentCost = costs[i - 1];

        
        int minCost = solve(i - 1, costs) + currentCost + 1;

        
        if (i >= 2) {
            minCost = Math.min(minCost, solve(i - 2, costs) + currentCost + 4);
        }

     
        if (i >= 3) {
            minCost = Math.min(minCost, solve(i - 3, costs) + currentCost + 9);
        }

        return memo[i] = minCost;
    }
}
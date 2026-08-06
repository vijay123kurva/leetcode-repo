class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i =0;
        int j = 0;
        int sum = 0;
        int maxSum = 0;
        while(j<k){
            sum +=nums[j++];
        }
        maxSum = sum;
        while(j<nums.length){
            sum-=nums[i++];
            sum+=nums[j++];
            maxSum = Math.max(sum,maxSum);
           
        }
        return maxSum/(double)k;
    }
}
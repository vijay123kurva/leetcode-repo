class Solution {
    public int pivotIndex(int[] nums) {
        int lSum = 0;
        int rSum = 0;
        int totalSum = 0;
        for(int r : nums){
            totalSum +=r;
        }

        int n = nums.length;
        for(int i=0;i<n;i++){
            if(lSum ==totalSum-lSum-nums[i]) return i;
            lSum +=nums[i];
        }
        return -1;
        
    }
}
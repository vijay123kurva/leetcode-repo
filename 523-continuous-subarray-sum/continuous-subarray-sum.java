class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int prefixSum = 0;
        mp.put(0,-1);
        int n = nums.length;
        for(int i=0;i<n;i++){
            prefixSum +=nums[i];
            int rem = prefixSum%k;
            if(mp.containsKey(rem)){
                if(i-mp.get(rem)>=2) return true;
            } else{
                mp.put(rem,i);

            } 
            
            

        }
        return false;
    }
}
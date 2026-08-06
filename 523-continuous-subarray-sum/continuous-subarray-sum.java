class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // remainder , Index
        HashMap<Integer,Integer> mp = new HashMap<>();
        int prefix = 0;
        mp.put(0,-1);
        for(int i=0;i<nums.length;i++){
            prefix +=nums[i];
            int rem = prefix%k;
            if(mp.containsKey(rem)){
                if(i-mp.get(rem)>=2) return true;
            }else{
                mp.put(rem,i);
            }
        }
        return false;
    }
}
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lMax = 0;
        int rMax = 0;
        int l = 0;
        int r = n-1;
        int ans = 0;
        while(l<r){
            lMax = Math.max(lMax,height[l]);
            rMax = Math.max(rMax,height[r]);
            if(lMax<rMax){
                ans+=lMax-height[l];
                l++;
            }else{
                ans+=rMax-height[r];
                r--;
            }
        }
        return ans;
    }
}
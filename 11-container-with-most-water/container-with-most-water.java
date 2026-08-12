class Solution {
    public int maxArea(int[] height) {
        int n = height.length-1;
        int i=0,j=n;
        int maxArea = 0;
        while(i<j){
            int area = (j-i)*Math.min(height[i],height[j]);
            maxArea = Math.max(maxArea,area);
            if(height[i]<=height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
        
    }
}
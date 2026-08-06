class Solution {
    public int numberOfSubstrings(String s) {
        int[]  arr  = {-1,-1,-1};
        int r = 0;
        int count = 0;
        while(r<s.length()){
            arr[s.charAt(r)-'a'] = r;
            if(arr[0] != -1 && arr[1] != -1 
            && arr[2] != -1){
                count += 1+Math.min(arr[0],Math.min(arr[1],arr[2]));
            }
            r++;
        }
        return count;
    }
}
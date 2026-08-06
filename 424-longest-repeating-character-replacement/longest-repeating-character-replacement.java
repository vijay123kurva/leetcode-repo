class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int maxLen = 0,freq = 0;
        int r =0,l=0;
        while(r<s.length()){
            arr[s.charAt(r)-'A']++;
            freq = Math.max(freq,arr[s.charAt(r)-'A']);
            if(r-l+1 - freq >k){
                arr[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
        
    }
}
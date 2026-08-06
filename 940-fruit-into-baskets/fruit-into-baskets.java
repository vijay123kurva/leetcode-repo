class Solution {
    public int totalFruit(int[] arr) {
        int st =0,end = 0;
        int maxLen = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        while(end<arr.length){
            mp.put(arr[end],mp.getOrDefault(arr[end],0)+1);
            if(mp.size()>2){
                mp.put(arr[st],mp.get(arr[st])-1);
                if(mp.get(arr[st])==0){
                    mp.remove(arr[st]);
                }
                st++;
            }
            if(mp.size()<=2){
                maxLen = Math.max(end-st+1,maxLen);
            }
            end++;
        }
        return maxLen;
    }
}
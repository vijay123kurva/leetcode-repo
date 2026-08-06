class Solution {
    public String minWindow(String s, String t) {
        int r = 0,l = 0,start = -1,minLen = Integer.MAX_VALUE,count = 0;
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        while(r<s.length()){
            char ch1 = s.charAt(r);
            if(mp.containsKey(ch1)){
                if(mp.get(ch1)>0){
                    count++;
                }
                mp.put(ch1,mp.get(ch1)-1);
            }
            while(count==t.length()){
                if(r-l+1<minLen){
                    minLen = r-l+1;
                    start = l;
                }
                char ch2 = s.charAt(l);
                if(mp.containsKey(ch2)){
                    mp.put(ch2,mp.get(ch2)+1);
                    if(mp.get(ch2)>0) count--;
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}
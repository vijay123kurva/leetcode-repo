class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        int left = 0;
        int right = 0;
        int start = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        while(right < n){

            char ch = s.charAt(right);

            if(map.containsKey(ch)){

                if(map.get(ch) > 0)
                    count++;

                map.put(ch,map.get(ch)-1);
            }


            while(count == t.length()){

                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }

                char cha = s.charAt(left);

                if(map.containsKey(cha)){
                    map.put(cha,map.get(cha)+1);

                    if(map.get(cha) > 0)
                        count--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}
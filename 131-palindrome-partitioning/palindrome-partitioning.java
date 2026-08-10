class Solution {
    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public void getAll(String s,List<List<String>>  ans,List<String> partition ){
        if(s.equals("")){
            ans.add(new ArrayList<>(partition));
            return;
        }
        for(int i=0;i<s.length();i++){
            String str = s.substring(0,i+1);
            if(isPalindrome(str)){
                partition.add(str);
                getAll(s.substring(i+1),ans,partition);
                partition.remove(partition.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>  ans = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        getAll(s,ans,partition);
        return ans;
    }
}